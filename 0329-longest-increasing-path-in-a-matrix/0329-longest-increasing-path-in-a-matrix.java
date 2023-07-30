class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 1;
        int dp[][] = new int[m][n];
        for (int row[]: dp)
            Arrays.fill(row, -1);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res = Math.max(res, dfs(matrix, r, c, -1, dp));
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length)
            return 0;
        
        if (matrix[r][c] <= prev)
            return 0;
        
        if (dp[r][c] != -1)
            return dp[r][c];
        
        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        
        int res = 0;
        for (int dir[]:dirs) {
            int newR = dir[0] + r, newC = dir[1] + c;
            res = Math.max(res, dfs(matrix, newR, newC, matrix[r][c], dp));
        }
        dp[r][c] = res + 1;
        return dp[r][c];
    }
}