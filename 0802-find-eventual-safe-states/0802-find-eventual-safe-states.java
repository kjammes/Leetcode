class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<Integer>[] reverseGraph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            reverseGraph[i] = new ArrayList<>();
        }
        
        int[] outdegree = new int[V];
        for (int node = 0; node < V; node++) {
            for (int ng : graph[node]) {
                reverseGraph[ng].add(node); // Reverse the direction of edges
                outdegree[node]++; // Increment outdegree of the current node
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < V; node++) {
            if (outdegree[node] == 0)
                q.offer(node);
        }
        
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            
            for (int ng : reverseGraph[node]) {
                outdegree[ng]--; // Decrement outdegree of the neighbor
                if (outdegree[ng] == 0)
                    q.offer(ng);
            }
        }
        Collections.sort(result);
        return result;
    }
}
