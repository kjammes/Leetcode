class Solution {
    
    int[][] dirs = {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, new boolean[image.length][image[0].length], image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int prevColor) {
        if (visited[sr][sc])
            return;

        int m = image.length, n = image[0].length;
        image[sr][sc] = color;
        visited[sr][sc] = true;
        
        for (int dir[]: dirs) {
            int nx = sr + dir[0], ny = sc + dir[1];
            if (nx >= 0  && nx < m && ny >= 0 && ny < n && image[nx][ny] == prevColor) {
                dfs(image, nx, ny, color, visited, prevColor);
            }
        }
        
        // return image;
    }
}