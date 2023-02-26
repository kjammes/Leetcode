class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int j = 0; j < len2 + 1; j++) 
            dp[len1][j] = len2 - j;
        
        for(int i = 0; i < len1 + 1; i++)
            dp[i][len2] = len1 - i;
        
        for(int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        
        return dp[0][0];
    }
}