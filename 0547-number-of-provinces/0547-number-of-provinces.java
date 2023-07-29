class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int m = isConnected.length;
        List<Integer>[] graph = new List[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 0)
                    continue;
                if (graph[i] == null) graph[i] = new ArrayList<>();
                if (graph[j] == null) graph[j] = new ArrayList<>();
                graph[i].add(j);
                graph[j].add(i);
            }
        }
        
        boolean visited[] = new boolean[m];
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (visited[i])
                continue;
            res++;
            dfs(graph, i, visited);
        }
        return res;
    }
    
    private void dfs(List<Integer>[] graph, int node,boolean[] visited) {
        if (visited[node])
            return;
        
        visited[node] = true;
        for (int n: graph[node]) {
            if (visited[n])
                continue;
            dfs(graph, n, visited);
        }
    }
}