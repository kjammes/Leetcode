class Solution {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        return burstBalloons(nums, 0, nums.length - 1, dp);
    }

    private int burstBalloons(int[] nums, int left, int right, int[][] dp) {
        if (left > right)
            return 0;
        
        if (dp[left][right] != 0)
            return dp[left][right];
        
        int coins = 0;
        for (int i = left; i <= right; i++) {
            int curCoins = nums[i];
            if (left - 1 >= 0) {
                curCoins *= nums[left - 1];
            }
            if (right + 1 < nums.length) {
                curCoins *= nums[right + 1];
            }
            curCoins += burstBalloons(nums, left, i - 1, dp) + burstBalloons(nums, i + 1, right, dp);
            coins = Math.max(coins, curCoins);
        }
        
        return dp[left][right] = coins;
    }
}
