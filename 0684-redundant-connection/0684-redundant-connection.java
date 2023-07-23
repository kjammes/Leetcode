class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (hasCycle(u, v, adj, new boolean[n + 1])) {
                return edge;
            }
            adj[u].add(v);
            adj[v].add(u);
        }

        return new int[0];
    }

    private boolean hasCycle(int u, int v, List<Integer>[] adj, boolean[] visited) {
        if (u == v) {
            return true;
        }
        visited[u] = true;
        for (int neighbor : adj[u]) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, v, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
