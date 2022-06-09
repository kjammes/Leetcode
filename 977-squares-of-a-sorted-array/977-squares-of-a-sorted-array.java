class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        
        int left = 0;
        int right = len - 1;
        
        int[] res = new int[len];
        int p = len - 1;
        
        while(left <= right) {
            int leSq = nums[left] * nums[left];
            int riSq = nums[right] * nums[right];
            
            if(leSq > riSq) {
                res[p--] = leSq;
                left++;
            } else {
                res[p--] = riSq;
                right--;
            }
        }
        
        return res;
    }
}