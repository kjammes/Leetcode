class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int max = 0;
        int curSum = 0;
        int i = 0, j = 0;
        
        boolean[] visited = new boolean[10001];
        while(j < nums.length) {
            while( j < nums.length && !visited[ nums[j] ] ) {
                curSum += nums[j];
                visited[ nums[j++] ] = true;
            } 
            
            max = Math.max(curSum, max);
            
            while( j < nums.length && visited[nums[j]]) {
                curSum -= nums[i];
                visited[ nums[i++] ] = false;
            }
        }
        
        return max;
    }
}