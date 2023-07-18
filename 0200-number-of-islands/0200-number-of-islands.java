class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res += 1;
                    dfs(grid, row, col);
                }
            }
        }
        return res;
    }
    
    private void dfs(char grid[][], int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;
        
        if (grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        dfs(grid, r, c + 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r - 1, c);
    }
}