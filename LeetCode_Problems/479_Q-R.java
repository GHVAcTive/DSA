class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        int upper = (int) Math.pow(10, n) - 1;
        for (int i = upper; i > upper / 10; i--) {
            long palindrome = createPalindrome(i);
            for (long j = upper; j * j >= palindrome; j--) {
                if (palindrome % j == 0) {
                    long other = palindrome / j;
                    if (other >= Math.pow(10, n - 1) && other <= upper) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }
        return 9;
    }

    private long createPalindrome(int half) {
        String str = Integer.toString(half);
        StringBuilder sb = new StringBuilder(str).reverse();
        return Long.parseLong(str + sb.toString());
    }
}
