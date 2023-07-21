class Solution {
    
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(r, 0, heights, pacific, Integer.MIN_VALUE);
            dfs(r, n - 1, heights, atlantic, Integer.MIN_VALUE);
        }
        
        for (int c = 0; c < n; c++) {
            dfs(0, c, heights, pacific, Integer.MIN_VALUE);
            dfs(m - 1, c, heights, atlantic, Integer.MIN_VALUE);
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (atlantic[r][c] && pacific[r][c])
                    res.add(Arrays.asList(r, c));
            }
        }
        
        return res;
    }
    
    private void dfs(int r, int c, int[][] heights, boolean[][] ocean, int prev) {
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        
        if (heights[r][c] < prev || ocean[r][c]) return;
        
        ocean[r][c] = true;
        for (int[] dir: dirs) {
            dfs(r + dir[0], c + dir[1], heights, ocean, heights[r][c]);
        }
    }

}