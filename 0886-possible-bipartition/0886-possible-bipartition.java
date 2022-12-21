class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] el: dislikes) {
            int a = el[0] - 1;
            int b = el[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i = 0; i < n; i++) {
            if(colors[i] == -1 && !dfs(graph, colors, i, 0))
                return false;
        }
        
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int[] colors, int el, int color) {
        if(colors[el] != -1) {
            return colors[el] == color;
        }
        
        colors[el] = color;
        for(int node: graph[el]) {
            if (!dfs(graph, colors, node, 1 - color))
                return false;
        }
        
        return true;
    }
}