class Solution {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        if (size == 1)
            return nums[0];
        int min = 1;
        int max = 1;
        int res = nums[0];

        for (int el: nums) {
            int temp = min * el;
            min = Math.min(el, Math.min(max * el, temp));
            max = Math.max(el, Math.max(max * el, temp));
            res = Math.max(res, max);
        }

        return res;
    }
}