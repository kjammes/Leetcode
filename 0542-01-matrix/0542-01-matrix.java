class Solution {

    int[][] dirs = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}  
    };
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int r = q.peek()[0], c = q.poll()[1];
            int dist = res[r][c];
            
            for (int dir[]: dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n)
                    continue;
                
                if (res[x][y] > dist + 1) {
                    res[x][y] = dist + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
        
        return res;
    }
}
