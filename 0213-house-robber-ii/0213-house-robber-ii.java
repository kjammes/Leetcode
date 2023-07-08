class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        return Math.max(
            robOne(nums, 0, nums.length - 1),
            robOne(nums, 1, nums.length)
        );
    }
    
    private int robOne(int[] nums, int s, int e) {
        int prevMax = 0;
        int curMax = 0;
        for (int i = s; i < e; i++) {
            int temp = Math.max(curMax, prevMax + nums[i]);
            prevMax = curMax;
            curMax = temp;
        }
        return curMax;
    }

}