class Solution {
   public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentDifference = Integer.MAX_VALUE;
        int currentNumber = target;
       
        for (int i = 0; i < nums.length - 2; i++) {
            
            int low = i + 1;
            int high = nums.length-1;
            
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
                
                int difference = Math.abs(target - sum);
                if (currentDifference > difference) {
                    currentDifference = difference;
                    currentNumber = sum;
                }
                
            }
        }
       
        return currentNumber;
    }
}