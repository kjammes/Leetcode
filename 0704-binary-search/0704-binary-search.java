class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + (right - left) / 2);
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            
            if (nums[mid] > target) 
                right = mid - 1;
            else
                left = mid + 1;
        }
        return res;
    }
}