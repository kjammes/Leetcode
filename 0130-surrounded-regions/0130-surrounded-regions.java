class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') 
                q.offer(new int[] {row, 0});
            if (board[row][n - 1] == 'O')
                q.offer(new int[] {row, n-1});
        }
        
        for (int col = 1; col < n - 1; col++) {
            if (board[0][col] == 'O')
                q.offer(new int[] {0, col});
            if (board[m - 1][col] == 'O')
                q.offer(new int[] {m - 1, col});
        }
        
        int[][] dirs = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}  
        };
        while (!q.isEmpty()) {
            int r = q.peek()[0], c = q.poll()[1];
            board[r][c] = 'Z';
            
            for (int dir[]: dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n)
                    continue;
                if (board[x][y] == 'O')
                    q.offer(new int[] {x, y});
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'Z')
                    board[row][col] = 'O';
                else if (board[row][col] == 'O')
                    board[row][col] = 'X';
            }
        }
    }
}