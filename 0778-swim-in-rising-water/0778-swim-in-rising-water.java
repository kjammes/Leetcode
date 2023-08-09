class Solution {
    
    int[][] dirs = {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
    
        int low = 0, high = n * n - 1;        
        while (low < high) {
            
            int mid = low + (high - low) / 2;
            boolean[][] visited = new boolean[n][n];
            
            if (dfs(0, 0, grid, mid, visited)) {
                high = mid;
            } else
                low = mid + 1;
        }
        
        return low;
    }
    
    private boolean dfs(int r, int c, int[][] grid, int target, boolean[][] visited) {
        int n = grid.length;
        
        if ( r < 0 || c < 0 || r >= n || c >= n || visited[r][c] || grid[r][c] > target)
            return false;
        
        visited[r][c] = true;
        
        if (r == n - 1 && c == n - 1)
            return true;
        
        boolean res = false;
        for (int dir[]: dirs) {
            int x = r + dir[0], y = c + dir[1];
            if (dfs(x, y, grid, target, visited)) {
                res = true;
                break;
            }
        }
        
        return res;
    }
}