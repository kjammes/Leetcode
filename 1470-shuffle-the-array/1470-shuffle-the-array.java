class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = n; i < 2*n; i++) {
            int secNum = nums[i] << 10;
            nums[i - n] = nums[i - n] | secNum;
        }
        
        int tenOnes = (int) Math.pow(2, 10) - 1;
        
        for (int i = n - 1; i >= 0; --i) {
            int secNum = nums[i] >> 10;
            int firstNum = nums[i] & tenOnes;
            
            nums[i * 2] = firstNum;
            nums[i * 2 + 1] = secNum;
        }
        
        return nums;
    }
}