class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        boolean[] visited = new boolean[n];
        int numVisitedNodes = 0;
        long numUnreachablePairsOfNodes = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int connectedNode = dfs(graph, visited, i);
            numUnreachablePairsOfNodes += (long) connectedNode * numVisitedNodes;
            numVisitedNodes += connectedNode;
        }
        
        return numUnreachablePairsOfNodes;
    }
    
    private int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int connectedNodes = 1;
        for (int child: graph.get(node)) {
            if (visited[child])
                continue;
            connectedNodes += dfs(graph, visited, child);
        }
        return connectedNodes;
    }
}