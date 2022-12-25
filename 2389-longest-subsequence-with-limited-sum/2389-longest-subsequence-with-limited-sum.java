class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int m = queries.length;
        
        int[] result = new int[m];
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        
        for(int i = 0; i < m; i++) {
            result[i] = bs(nums, queries[i]);
        }
        return result;
    }
    
    private int bs(int[] nums, int query) {
        int low = 0, high = nums.length - 1;
        int result = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == query) {
                result = mid + 1;
                break;
            } else if(nums[mid] < query) {
                result = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}