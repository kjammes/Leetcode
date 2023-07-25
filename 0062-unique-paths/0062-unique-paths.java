class Solution {
    public int uniquePaths(int m, int n) {
        int paths[][] = new int[m][n];

        for(int i = 0 ; i<n ; i++)
            paths[0][i] = 1;
        for(int i = 0 ; i<m ; i++)
            paths[i][0] = 1;
        
        
        for(int row=1 ; row<m ; row++)
            for(int col=1 ; col<n ; col++){
                paths[row][col] = paths[row-1][col] + paths[row][col-1];
            }
        
        return paths[m-1][n-1];
    }
}