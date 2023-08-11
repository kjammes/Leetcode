class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curMax = nums[0];
        
        if(nums.length == 1)
          return nums[0];
        
        int cnt = 0;
        for (int el: nums) {
            if (cnt++ == 0)
                continue;
            curMax = Math.max(curMax + el, el);
            res = Math.max(res, curMax);
        }
        
        return res;
    }
}