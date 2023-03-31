class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        Integer[][][] dp = new Integer[k][m][n];

        int apples[][] = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                apples[i][j] = 
                    apples[i][j+1] + apples[i+1][j] - apples[i+1][j+1] 
                    + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        return f(m, n, k - 1, 0, 0, dp, apples);
    }

    private int f(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] apples) {
        if (apples[r][c] == 0)
            return 0;
        if (k == 0)
            return 1;
        if (dp[k][r][c] != null)
            return dp[k][r][c];
        
        int ans = 0;

        for (int nr = r + 1; nr < m; nr++) {
            if ((apples[r][c] - apples[nr][c]) > 0)
                ans = (ans + f(m, n, k - 1, nr, c, dp, apples)) % 1_000_000_007;
        }

        for (int nc = c + 1; nc < n; nc++) {
            if ((apples[r][c] - apples[r][nc]) > 0)
                ans = (ans + f(m, n, k - 1, r, nc, dp, apples)) % 1_000_000_007;
        }

        return dp[k][r][c] = ans;
    }
}