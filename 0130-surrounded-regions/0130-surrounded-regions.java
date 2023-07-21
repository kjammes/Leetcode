class Solution {
    
    int rows, cols;
    int[][] dirs = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    
    public void solve(char[][] board) {
        rows = board.length; cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][cols - 1] == 'O') dfs(board, r, cols - 1);
        }
        
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[rows - 1][c] == 'O') dfs(board, rows - 1, c);
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'T') board[r][c] = 'O';  
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c) {
        if (
            r < 0 || c < 0 ||
            r >= rows || c >= cols || board[r][c] != 'O'
        )
            return;
        
        board[r][c] = 'T';
        for (int[] dir: dirs) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}