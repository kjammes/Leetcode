class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] flatmap = new int[m * n];
        int pointer = 0;
        for (int i = 0 ;i < m; i++) {
            for (int j = 0; j < n; j++) {
                flatmap[pointer++] = matrix[i][j];
            }
        }
        
        boolean res = false;
        int left = 0, right = pointer - 1;
        
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (flatmap[mid] == target) {
                res = true;
                break;
            }
            if (flatmap[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
            
        return res;
    }
}