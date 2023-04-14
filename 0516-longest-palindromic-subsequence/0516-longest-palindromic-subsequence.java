class Solution {

    int[][] dp;
    String s;

    public int longestPalindromeSubseq(String s) {
        int len = s.length();        
        dp = new int[len][len];
        this.s = s;

        return f(0, len -1);
    }

    private int f(int l, int r) {
        if (l > r)
            return 0;

        if (dp[l][r] != 0)
            return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            int res = l == r ? 1 : 2;
            dp[l][r] += res + f(l+1, r-1);
        } else {
            dp[l][r] = Math.max(
                f(l+1, r),
                f(l, r-1)
            );
        }

        return dp[l][r];
    }
}