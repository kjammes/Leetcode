class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int high = m * n, low = 0;
        while (high > low) {
            int mid = low + (high - low) / 2;
            if (matrix[mid/n][mid%n] == target)
                return true;
            else if (matrix[mid/n][mid%n] < target)
                low = mid + 1;
            else
                high = mid;
        }
            
        return false;
    }
}