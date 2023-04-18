class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return kthLargest(nums, k, 0, nums.length - 1);
    }

    private int kthLargest(int[] nums, int k, int l, int r) {
        int pivot = nums[r];
        int p = l;
        
        for (int  i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, r);

        if (p > k) 
            return kthLargest(nums, k, l, p - 1);
        else if (p < k)
            return kthLargest(nums, k, p + 1, r);
        else 
            return nums[p];
    }

    private void swap(int[] nums, int idxOne, int idxTwo) {
        int temp = nums[idxOne];
        nums[idxOne] = nums[idxTwo];
        nums[idxTwo] = temp;
    }
}