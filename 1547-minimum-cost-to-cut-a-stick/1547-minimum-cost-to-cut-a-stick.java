class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0; newCuts[cuts.length + 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i + 1] = cuts[i];
        }
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        return helper(1, newCuts.length - 2, newCuts, dp);
    }
    
    private int helper(int start, int end, int[] cuts, int[][] dp) {
        if (start > end)
            return 0;
        
        // System.out.println("start : " + start + " end : " + end);
        if (dp[start][end] != 0)
            return dp[start][end];
        
        int cost = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int curCost = cuts[end + 1] - cuts[start - 1] +
                          helper(start, i - 1, cuts, dp) + helper(i + 1, end, cuts, dp);
            cost = Math.min(cost, curCost);
        }
        
        return dp[start][end] = cost;
    }
}