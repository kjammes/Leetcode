class Solution {
    
    int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (
                    board[row][col] == word.charAt(0) &&
                    helper(board, word, row, col, 0, new boolean[m][n])
                )
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int row, int col, int idx, boolean[][] visited) {
        if (board[row][col] != word.charAt(idx))
            return false;
        if (idx == word.length() - 1)
            return true;
        
        visited[row][col] = true;
        
        for (int[] dir: dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (inBound(x, y) && !visited[x][y] && helper(board, word, x, y, idx + 1, visited))
                return true;
        }
        
        visited[row][col] = false; // Backtrack
        
        return false;
    }
    
    private boolean inBound(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
