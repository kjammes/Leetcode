class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        // dp[i][j] will store the number of distinct subsequences of s[0...i-1] which equals t[0...j-1].
        int[][] dp = new int[sLen + 1][tLen + 1];
        
        // For any i, dp[i][0] should be 1 because there is one way to form an empty string from any non-empty string.
        for (int i = 0; i <= sLen; i++)
            dp[i][0] = 1;
        
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                // If the characters match, we have two choices:
                // 1. We can include the current character in both s and t to form the subsequence.
                // 2. We can exclude the current character from s and consider the previous subsequence.
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    // If the characters don't match, we can only exclude the current character from s.
                    dp[i][j] = dp[i - 1][j];
            }
        }
        
        return dp[sLen][tLen];
    }
}
