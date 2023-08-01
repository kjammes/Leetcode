class Solution {
    public int maxCoins(int[] nums) {
        int[] numsWithBoundary = new int[nums.length + 2];
        numsWithBoundary[0] = numsWithBoundary[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            numsWithBoundary[i + 1] = nums[i];
        }
        int dp[][] = new int[nums.length + 2][nums.length + 2];
        return burstBalloons(numsWithBoundary, 0, numsWithBoundary.length - 1, dp);
    }

    private int burstBalloons(int[] nums, int left, int right, int[][] dp) {
        if (left + 1 == right) {
            return 0;
        }
        
        if (dp[left][right] != 0)
            return dp[left][right];

        int maxCoins = 0;
        for (int i = left + 1; i < right; i++) {
            int coins = nums[left] * nums[i] * nums[right] 
                        + burstBalloons(nums, left, i, dp) 
                        + burstBalloons(nums, i, right, dp);
            maxCoins = Math.max(maxCoins, coins);
        }

        dp[left][right] = maxCoins;
        return maxCoins;
    }
}
