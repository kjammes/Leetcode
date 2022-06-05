class Solution {
    int sol = 0;
    public int totalNQueens(int n) {
        int[] before = new int[n];
        int[] upDi   = new int[n * 2 - 1];
        int[] loDi   = new int[n * 2 - 1];
        
        f(before, upDi, loDi, 0, n);
        
        return sol;
    }
    
    private void f(int[] before, int[] upDi, int[] loDi, int col, int n) {
        if(col == n) {
            sol = sol + 1;
            return;
        }
        
        for(int row = 0; row < n; row++) {
            if(
                before[row] == 0 &&
                upDi[row + col] == 0 &&
                loDi[(n-1) + (col - row)] == 0
            ) {
                // board[row][col] = 'Q';
                before[row] = 1;
                upDi[row + col] = 1;
                loDi[(n-1) + (col - row) ] = 1;
                
                f(before, upDi, loDi, col + 1, n);
                
                // board[row][col] = 'Q';
                before[row] = 0;
                upDi[row + col] = 0;
                loDi[(n-1) + (col - row) ] = 0;
            }
        }
    }
}