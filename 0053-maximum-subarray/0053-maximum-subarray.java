class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int el = nums[i];
            max = Math.max(el, max + el);
            sum = Math.max(max, sum);
        }
        
        return sum;
    }
}