class Solution {    
    /**
    *
    *
    */
    private final int STARTING_SQUARE = 1;
    private final int ENDING_SQUARE = 2;
    private final int CAN_WALK = 0;
    private final int OBSTACLE = -1;
    
    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int startXCor = 0;
        int startYCor = 0;
        
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == CAN_WALK)
                    zeroCount++;
                else if(grid[row][col] == STARTING_SQUARE) {
                    startXCor = row;
                    startYCor = col;
                }
            }
        }
        
        return dfs(grid, startXCor, startYCor, zeroCount);
    }
    
    private int dfs(int[][] grid, int x, int y, int zeroCount) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == OBSTACLE) 
            return 0;
        
        if (grid[x][y] == ENDING_SQUARE)
            return zeroCount == -1 ? 1 : 0;
        
        grid[x][y] = -1;
        zeroCount--;
        
        int result = dfs(grid, x + 1, y, zeroCount) + dfs(grid, x - 1, y, zeroCount)
                   + dfs(grid, x, y + 1, zeroCount) + dfs(grid, x, y - 1, zeroCount);
        
        grid[x][y] = 0;
        // zeroCount++;
        
        return result;
    }
}