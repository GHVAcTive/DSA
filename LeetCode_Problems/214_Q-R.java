class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = computeLPSArray(combined);
        int toAdd = s.length() - lps[combined.length() - 1];
        return rev.substring(0, toAdd) + s;
    }

    private int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; ) {
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
