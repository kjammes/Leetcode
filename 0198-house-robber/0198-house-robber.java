class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if (len == 1)
            return nums[0];
        
        int dp[] = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[len];
    }
}