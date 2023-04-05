class Solution {
    public int minimizeArrayValue(int[] nums) {
        int res = nums[0];
        double total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            res = (int) Math.max( (double) res, Math.ceil(total / (i + 1) ) );
        }
        return res;
    }
}