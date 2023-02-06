class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (nums.length <= 2)
            return nums;
        
        int[] res = new int[2*n];
        int p1 = 0, p2 = n;
        int resP = 0;
        while (p1 < n && p2 < 2*n ) {
            res[resP++] = nums[p1++];
            res[resP++] = nums[p2++];
        }
        
        return res;
    }
}