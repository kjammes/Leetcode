class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int maxSum = 0;
        for (int el : nums)
            maxSum += el;
        
        // Since the sum can range from -maxSum to +maxSum, we need to add 1 to include 0.
        int dp[][] = new int[nums.length][2 * maxSum + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        // To handle cases where cur=0, we need to add maxSum to the recursive call.
        return f(nums, target, 0, 0, dp, maxSum);
    }
    
    private int f(int[] nums, int target, int cur, int idx, int[][] dp, int maxSum) {
        if (cur + maxSum < 0)
            return 0;
        
        if (idx == nums.length) 
            return cur == target ? 1 : 0;
        
        if (dp[idx][cur + maxSum] != -1)
            return dp[idx][cur + maxSum];
   
        dp[idx][cur + maxSum] = f(nums, target, cur + nums[idx], idx + 1, dp, maxSum) + 
                                f(nums, target, cur - nums[idx], idx + 1, dp, maxSum);
        
        return dp[idx][cur + maxSum];
    }
}
