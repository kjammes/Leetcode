class Solution {
    public int totalNQueens(int n) {
        int[] before = new int[n];
        int[] upDi   = new int[n * 2 - 1];
        int[] loDi   = new int[n * 2 - 1];
        
        return f(before, upDi, loDi, 0, n, 0);
    }
    
    private int f(int[] before, int[] upDi, int[] loDi, int col, int n, int count) {
        if(col == n) {
            count = count + 1;
            return count;
        }
        
        for(int row = 0; row < n; row++) {
            if(
                before[row] == 0 &&
                upDi[row + col] == 0 &&
                loDi[(n-1) + (col - row)] == 0
            ) {
                before[row] = 1;
                upDi[row + col] = 1;
                loDi[(n-1) + (col - row) ] = 1;
                
                count = f(before, upDi, loDi, col + 1, n, count);
                
                before[row] = 0;
                upDi[row + col] = 0;
                loDi[(n-1) + (col - row) ] = 0;
            }
        }
        
        return count;
    }
}