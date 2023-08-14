class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V];
        for (int node = 0; node < V; node++) {
            if (visited[node])
                continue;
            dfs(graph, node, visited, pathVisited, check);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int node = 0; node < V; node++) {
            if (check[node])
                result.add(node);
        }
        return result;
    }
    
    private boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] pathVisited, boolean[] check) {
        visited[node] = true;
        pathVisited[node] = true;
        
        for (int ng: graph[node]) {
            if (!visited[ng] && dfs(graph, ng, visited, pathVisited, check))
                return true;
            else if (pathVisited[ng])
                return true;
        }
        
        check[node] = true;
        pathVisited[node] = false;
        
        return false;
    }
}