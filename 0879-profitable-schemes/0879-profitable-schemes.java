class Solution {

    int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[n+1][group.length+1][minProfit+1];
        for (int i = 0; i <= n; i++) 
            for (int j = 0; j <= group.length; j++)
                dp[i][j][0] = 1;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= group.length; j++) {
                int m = group[j - 1]; // members
                int p = profit[j - 1]; // current profit
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i][j-1][k];
                    if (i < m)
                        continue;
                    int remain = Math.max(k - p, 0);
                    dp[i][j][k] += dp[i - m][j-1][remain];
                    dp[i][j][k] %= MOD;
                }
            }
        }

        return dp[n][group.length][minProfit];    
    }

}