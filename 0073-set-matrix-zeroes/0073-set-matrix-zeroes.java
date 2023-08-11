class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] copy = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                copy[r][c] = matrix[r][c];
            }
        }
        
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    turnToZeroes(copy, r, c);
                }
            }
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = copy[r][c];
            }
        }
    }
    
    private void turnToZeroes(int[][] matrix, int r, int c) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][c] = 0;
        }
        
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[r][col] = 0;
        }
    }
}