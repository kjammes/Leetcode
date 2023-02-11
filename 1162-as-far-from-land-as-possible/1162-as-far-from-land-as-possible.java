class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if (grid[r][c] == 1)
                    q.add(new int[] {r, c});
            }
        }
        
        int result = -1;
        while (!q.isEmpty()) {
            int[] rowCol = q.remove();
            int row = rowCol[0];
            int col = rowCol[1];
            
            result = grid[row][col];
            
            int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
            for(int[] dir: dirs) {
                int x = row + dir[0], y = col + dir[1];
                if (
                    Math.min(x, y) >= 0 &&
                    Math.max(x, y) < n &&
                    grid[x][y] == 0
                ) {
                    q.add(new int[] {x, y});
                    grid[x][y] = grid[row][col] + 1;
                }
            }
        }
        
        return result > 1 ? result - 1 : -1;
    }
}