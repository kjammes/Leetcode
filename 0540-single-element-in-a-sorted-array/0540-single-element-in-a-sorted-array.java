class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l =0, r = nums.length - 1;
        
        while(l <= r) {
            int m = l + ((r - l) / 2);
            
            if (
                ( m - 1 < 0 || nums[m-1] != nums[m] ) &&
                ( m + 1 == nums.length || nums[m+1] != nums[m] )
            ) {
                return nums[m];
            }
            
            int prev = m-1 < 0 ? nums.length - 1 : m -1;
            int leftSize = nums[prev] == nums[m] ? m - 1 : m;
            if (leftSize % 2 == 0)
                l = m + 1;
            else
                r = m - 1;
        }
        
        return 1;
    }
}