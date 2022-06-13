class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for(int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        
        return dp[0];
    }
}