class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(nums);
        for(int i = 0; i < queries.length; i++) {
            result[i] = longestCount(queries[i], nums);
        }
        return result;
    }
    
    private int longestCount(int sum, int[] nums) {
        int curSum = 0;
        int result = 0;
        for(int num: nums) {
            if(curSum + num <= sum) {
                curSum += num;
                result++;
            }
            
            if(curSum >= sum) return result;
        }
        return result;
    }
}