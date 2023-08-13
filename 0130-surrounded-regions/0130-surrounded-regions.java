class Solution {
    
    int[][] dirs = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}  
    };
    
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') 
                dfs(row, 0, board);
            if (board[row][n - 1] == 'O')
                dfs(row, n-1, board);
        }
        
        for (int col = 1; col < n - 1; col++) {
            if (board[0][col] == 'O')
                dfs(0, col, board);
            if (board[m - 1][col] == 'O')
                dfs(m - 1, col, board);
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
    
    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
            return;
        
        board[r][c] = 'Z';
        for (int[] dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            dfs(x, y, board);
        }
    }
}