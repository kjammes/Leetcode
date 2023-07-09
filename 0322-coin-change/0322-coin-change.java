// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int dp[] = new int[amount + 1];
//         Arrays.fill(dp, -1);
//         int result = coinChangeRecursive(coins, amount, dp);
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
    
//     private int coinChangeRecursive(int[] coins, int amount, int[] dp) {
//         if (amount == 0) {
//             return 0;
//         }
        
//         if (amount < 0) {
//             return Integer.MAX_VALUE;
//         }
        
//         if (dp[amount] != -1) 
//             return dp[amount];
        
//         int minCoins = Integer.MAX_VALUE;
//         for (int i = 0; i < coins.length; i++) {
//             int subproblem = coinChangeRecursive(coins, amount - coins[i], dp);
//             if (subproblem != Integer.MAX_VALUE) {
//                 minCoins = Math.min(minCoins, 1 + subproblem);
//             }
//         }
        
//         dp[amount] = minCoins;
//         return minCoins;
//     }
// }


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
