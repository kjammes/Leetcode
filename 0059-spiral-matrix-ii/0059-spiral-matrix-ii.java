class Solution {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int num = 1;
        final int lastNum = n * n;

        int left = 0, right = n - 1;
        int top  = 0, bottom = n - 1;

        while (true) {
            for (int i = left; i <= right; i++) res[top][i] = num++;
            top++;
            if (right < left || top > bottom)
                break;

            for (int i = top; i <= bottom; i++) res[i][right] = num++;
            right--;
            if (right < left || top > bottom)
                break;

            for (int i = right; i >= left; i--) res[bottom][i] = num++;
            bottom--;
            if (right < left || top > bottom)
                break;

            for (int i = bottom; i >= top; i--) res[i][left] = num++;
            left++;
            if (right < left || top > bottom)
                break;
        }

        return res;
    }
}