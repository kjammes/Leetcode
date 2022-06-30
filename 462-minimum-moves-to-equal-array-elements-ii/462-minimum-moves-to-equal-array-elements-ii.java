class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        
        int med = len%2 == 0 ? ( nums[len/2] + nums[len/2 - 1] ) / 2 : nums[len/2];
        
        int res = 0;
        for(int el: nums)
            res += Math.abs(med - el);
        
        return res;
    }
}