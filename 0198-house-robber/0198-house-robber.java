class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        // int dp[] = new int[len + 1];
        // dp[1] = nums[0];
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        int dp = dp2;
        for (int i = 2; i < nums.length; i++) {
            // dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            dp = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = dp;
        }
        // return dp[len];
        return dp;
    }
}