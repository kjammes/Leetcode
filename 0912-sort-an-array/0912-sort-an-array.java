class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        
        if (len == 1)
            return nums;
        
        int[] left = Arrays.copyOfRange(nums, 0, len/2);
        int[] right = Arrays.copyOfRange(nums, len/2, len);
        
        return merge(sortArray(left), sortArray(right));
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        
        int p1 = 0, p2 = 0;
        int resP = 0;
        while (p1 < left.length && p2 < right.length) {
            if (left[p1] < right[p2])
                res[resP++] = left[p1++];
            else
                res[resP++] = right[p2++];
        }
        
        while (p1 < left.length) {
            res[resP++] = left[p1++];
        }
        
        while (p2 < right.length) {
            res[resP++] = right[p2++];
        }
        
        return res;
    }
    
    
}