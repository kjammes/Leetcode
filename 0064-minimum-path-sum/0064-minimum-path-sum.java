class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0)
                    continue;
                else if (row == 0)
                    dp[row][col] = dp[row][col - 1] + grid[row][col];
                else if (col == 0)
                    dp[row][col] = grid[row][col] + dp[row - 1][col];
                else
                    dp[row][col] = 
                    Math.min(grid[row][col] + dp[row-1][col], grid[row][col] + dp[row][col-1]);
            }
        }

        return dp[m- 1][n- 1];
    }
}