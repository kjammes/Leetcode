class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low < high) {
            int middle = low + ((high - low + 1) / 2);
            if(target < nums[middle])
                high = middle - 1;
            else
                low = middle;
        }
        
        return nums[low] == target ? low : -1;
    }
}