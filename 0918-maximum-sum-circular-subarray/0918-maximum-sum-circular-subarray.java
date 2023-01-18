class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max1 = kadane(nums);
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = -nums[i];
        }
        
        int min = kadane(nums);
        int max2 = sum + min;
        
        if (max2 == 0) return max1;
        
        return Math.max(max1, max2);
    }
    
    private int kadane(int[] arr) {
        int max = arr[0];
        int maxSum = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            int el = arr[i];
            
            maxSum = Math.max(maxSum + arr[i], arr[i]);
            
            max = Math.max(max, maxSum);
        }
        
        return max;
    }
}