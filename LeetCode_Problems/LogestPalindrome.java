class Solution {
    public String longestPalindrome(String s)  {
        if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Even-length palindrome
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Update longest palindrome
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            } // COndition If
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the substring between left+1 and right
        return s.substring(left + 1, right);
    }
}
