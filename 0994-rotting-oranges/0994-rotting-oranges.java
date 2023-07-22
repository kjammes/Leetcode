class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2)
                    q.offer(new int[] {r, c});
                else if (grid[r][c] == 1)
                    fresh++;
            }
        }
        
        int res = 0;
        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        while (!q.isEmpty() && fresh > 0) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int XY[] = q.poll();
                for (int[] dir: dirs) {
                    int x = XY[0] + dir[0], y = XY[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.offer(new int[] {x, y});
                }
            }
        }
        
        return fresh == 0 ? res : -1;
    }
}