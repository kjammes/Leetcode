class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;
        
        while (true) {
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;
            if (right < left || top > bottom)
                break;
            
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;
            if (right < left || top > bottom)
                break;
            
            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);
            bottom--;
            if (right < left || top > bottom)
                break;
            
            for (int i = bottom; i >= top; i--)
                res.add(matrix[i][left]);
            left++;
            if (right < left || top > bottom)
                break;
        }
        
        return res;
    }
}