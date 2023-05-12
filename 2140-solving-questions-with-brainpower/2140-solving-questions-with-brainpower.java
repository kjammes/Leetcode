class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len + 1];
        
        for (int idx = len - 1; idx >= 0; idx--) {
            int point = questions[idx][0];
            int brainpower = questions[idx][1];

            int nextPoint = Math.min(len, idx + brainpower + 1);
            dp[idx] = Math.max(dp[idx + 1], point + dp[nextPoint]);
        }

        return dp[0];
        // return getPoints(0, dp, questions);
    }

    private long getPoints(int idx, long[] dp, int[][] questions) {
        if (idx >= questions.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        long choose = questions[idx][0] + getPoints(idx + questions[idx][1] + 1, dp, questions);
        long skip   = getPoints(idx + 1, dp, questions);

        dp[idx] = Math.max(choose, skip);

        return dp[idx];
    }
}