class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();
        char[][] board = new char[n][n];
        
        int[] rowCache = new int[n];
        int[] upDiagonal = new int[2 * n - 1];
        int[] loDiagonal = new int[2 * n - 1];
        
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                board[i][j] = '.';
        
        solve(0, board, sol, n, rowCache, upDiagonal, loDiagonal);
        return sol;
    }
    
    private void solve(int col, char[][] board, List<List<String>> sol, int n, int[] rowCache, int[] upDiagonal, int[] loDiagonal) {
        if(col == n) {
            sol.add(construct(board));
            return;
        }
        
        for(int row = 0; row < n; row++) {
            if(rowCache[row] == 0 && upDiagonal[row + col] == 0 && loDiagonal[(n-1) + (col - row)] == 0) {
                
                board[row][col] = 'Q';
                
                rowCache[row] = 1;
                upDiagonal[row + col] = 1;
                loDiagonal[(n-1) + (col - row)] = 1;
                
                solve(col + 1, board, sol, n, rowCache, upDiagonal, loDiagonal);
                board[row][col] = '.';
                
                rowCache[row] = 0;
                upDiagonal[row + col] = 0;
                loDiagonal[(n-1) + (col - row)] = 0;
            }
        }
    }
    
    private List<String> construct(char[][] board) {
        List <String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    
}