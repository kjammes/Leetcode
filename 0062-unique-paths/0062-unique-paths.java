class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row[]: dp)
            Arrays.fill(row, -1);
        return f(m, n, 0, 0, dp);
    }
    
    private int f(int m, int n, int r, int c, int[][] dp) {
        if (r == m || c == n)
            return 0;
        if (dp[r][c] != -1)
            return dp[r][c];
        if (r == m - 1 && c == n - 1)
            return 1;
        
        dp[r][c] = f(m, n, r + 1, c, dp) + f(m, n, r, c + 1, dp);
        return dp[r][c];
    }
}