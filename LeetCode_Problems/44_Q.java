class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        
        // DP table
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string and empty pattern match
        dp[0][0] = true;
        
        // Fill first row for patterns with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                char sc = s.charAt(i - 1);
                
                // If characters match or pattern has '?'
                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If pattern has '*', either match 0 or more characters
                else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
