class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int max = 0;
        int curSum = 0;
        
        Set<Integer> visited = new HashSet<>();
        for(int i = 0, j = 0; i < nums.length && j < nums.length;) {
            if(!visited.contains(nums[j])) {
                curSum += nums[j];
                max = Math.max(curSum, max);
                visited.add(nums[j++]);
            } else {
                curSum -= nums[i];
                visited.remove(nums[i++]);
            }
        }
        
        return max;
    }
}