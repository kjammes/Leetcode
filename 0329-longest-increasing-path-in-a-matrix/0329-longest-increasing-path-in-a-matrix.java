// class Solution {
//     public int longestIncreasingPath(int[][] matrix) {
//         int m = matrix.length, n = matrix[0].length;
//         int res = 1;
//         int dp[][] = new int[m][n];
//         for (int row[]: dp)
//             Arrays.fill(row, -1);
//         for (int r = 0; r < m; r++) {
//             for (int c = 0; c < n; c++) {
//                 res = Math.max(res, dfs(matrix, r, c, -1, dp));
//             }
//         }
//         return res;
//     }
    
//     private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp) {
//         if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length)
//             return 0;
        
//         if (matrix[r][c] <= prev)
//             return 0;
        
//         if (dp[r][c] != -1)
//             return dp[r][c];
        
//         int[][] dirs = {
//             {0, 1}, {1, 0}, {0, -1}, {-1, 0}
//         };
        
//         int res = 0;
//         for (int dir[]:dirs) {
//             int newR = dir[0] + r, newC = dir[1] + c;
//             res = Math.max(res, dfs(matrix, newR, newC, matrix[r][c], dp));
//         }
//         dp[r][c] = res + 1;
//         return dp[r][c];
//     }
// }

class Solution {
    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return 0;

        int cols = matrix[0].length;
        int[][] indegree = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                for (int[] direction : DIRECTIONS) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                        if (matrix[nx][ny] < matrix[x][y]) {
                            indegree[x][y]++;
                        }
                    }
                }
                if (indegree[x][y] == 0) {
                    queue.add(new int[]{x, y});
                }
            }
        }
        
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] direction : DIRECTIONS) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                        if (matrix[nx][ny] > matrix[x][y]) {
                            indegree[nx][ny]--;
                            if (indegree[nx][ny] == 0) {
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            pathLength++;
        }
        
        return pathLength;
    }
}
