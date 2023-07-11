class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 1;
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int start = len - 1; start >= 0; start--) {
            for (int idx = start + 1; idx < len; idx++) {
                if (nums[idx] > nums[start])
                    dp[start] = Math.max(dp[start], 1 + dp[idx]);
            }
            res = Math.max(res, dp[start]);
        }
        return res;
    }
}