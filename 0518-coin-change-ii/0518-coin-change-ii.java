class Solution {

    // int dp[][];

    // public int change(int amount, int[] coins) {
    //     dp = new int[coins.length][amount + 1];
    //     for (int el[]: dp)
    //         Arrays.fill(el, -1);
    //     return dfs(amount, coins, 0);
    // }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

//     private int dfs(int amount, int[] coins, int idx) {
//         if (idx == coins.length || amount <  0)
//             return 0;

//         if (dp[idx][amount] != -1)
//             return dp[idx][amount];

//         if (amount == 0)
//             return 1;

//         int useCoin = dfs(amount - coins[idx], coins, idx);
//         int notUse = dfs(amount, coins, idx + 1);
//         int res = useCoin + notUse;

//         dp[idx][amount] = res;
//         return res;
//     }
}