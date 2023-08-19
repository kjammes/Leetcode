class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        
        // Initialize the adjacency matrix with maximum distance values
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i] = 0;
        }
        
        // Fill the adjacency matrix with edge weights
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u][v] = w;
            adj[v][u] = w;
        }
        
        // Floyd-Warshall algorithm to find shortest paths between all pairs of nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }
        }
        
        int minReachableCities = n + 1; // Initialize with a value larger than n
        int result = -1;
        
        // Check each city's reachable cities and count how many are within the threshold
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && adj[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            
            if (reachableCount <= minReachableCities) {
                minReachableCities = reachableCount;
                result = i;
            }
        }
        
        return result;
    }
}
