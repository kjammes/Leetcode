class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (!bfs(graph, i, colors))
                return false;
        }
        return true;
    }
    
    private boolean bfs(int[][] graph, int node, int[] colors) {
        if (colors[node] != 0)
            return true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        colors[node] = 1;
        
        while (!q.isEmpty()) {
            int curNode = q.poll();
            
            for (int ng: graph[curNode]) {
                
                if (colors[ng] == 0) {
                    colors[ng] = -colors[curNode];
                    q.offer(ng);
                } else if (colors[ng] == colors[curNode])
                    return false;
            }
        }
        
        return true;
    }
}