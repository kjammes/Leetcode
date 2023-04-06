class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int res = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0 && isClosedIsland(grid, row, col))
                    res++;
            }
        }
        
        return res;
    }
    
    private boolean isClosedIsland(int[][] grid, int row, int col) {
        if (
            row < 0 || 
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length
        )
            return false;
        
        if (grid[row][col] == 1)
            return true;
        
        grid[row][col] = 1;
        boolean up = isClosedIsland(grid, row - 1, col);
        boolean right = isClosedIsland(grid, row, col + 1);
        boolean down = isClosedIsland(grid, row + 1, col);
        boolean left = isClosedIsland(grid, row, col - 1);
        
        return up && right && down && left;
    }
}
