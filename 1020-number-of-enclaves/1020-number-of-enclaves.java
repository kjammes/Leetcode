class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            if (grid[row][0] == 1)
                f(grid, row, 0);
            if (grid[row][cols - 1] == 1)
                f(grid, row, cols - 1);
        }

        for (int col = 1; col < cols - 1; col++) {
            if (grid[0][col] == 1)
                f(grid, 0, col);
            if (grid[rows - 1][col] == 1)
                f(grid, rows - 1, col);
        }

        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) res++;
            }
        }

        return res;
    }

    private void f(int[][] grid, int row, int col) {
        grid[row][col] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (
                x >= 0 && 
                x < grid.length && 
                y >= 0 && 
                y < grid[0].length && 
                grid[x][y] == 1
            ) {
                f(grid, x, y);
            }
        }
    }

    // private int f(int[][] grid, int row, int col) {
    //     if (grid[row][col] == 0)
    //         return 0;

    //     if (
    //         row < 0 ||
    //         row > grid.length ||
    //         col < 0 ||
    //         col > grid[0].length
    //     ){
    //         grid[row][col] = 0;
    //         return;
    //     }
            

    //     count++;
    //     grid[row][col] = 0;
    //     count += canReachBoundary(grid, row + 1, col, count);
    //     count += canReachBoundary(grid, row - 1, col, count);
    //     count += canReachBoundary(grid, row, col + 1, count);
    //     count += canReachBoundary(grid, row, col - 1, count);

    //     return count;
    // }
}