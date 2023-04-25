class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0;
        while (row < m) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midEl = matrix[row][mid];
                
                if (midEl == target) 
                    return true;
                
                if (midEl < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            row++;
        }
            
        return false;
    }
}