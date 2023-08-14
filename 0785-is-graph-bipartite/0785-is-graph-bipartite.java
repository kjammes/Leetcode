class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, i, colors, 1))
                return false;
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int node, int[] colors, int color) {
        if (colors[node] != 0)
            return true;
        
        colors[node] = color;
        for (int ng: graph[node]) {
            if (colors[ng] == color)
                return false;
            if (!dfs(graph, ng, colors, -color))
                return false;
        }
        return true;
    }
}