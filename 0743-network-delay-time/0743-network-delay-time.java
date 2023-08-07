class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : times) {
            graph[edge[0]].add(new int[] { edge[1], edge[2] });
        }

        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { k, 0 });
        Set<Integer> visited = new HashSet<>();
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], weight = current[1];
            
            if (visited.contains(node))
                continue;
            
            visited.add(node);
            res = weight; // Update the result only when a new node is visited
            
            for (int[] nbr : graph[node]) {
                int nbrNode = nbr[0], nbrWeight = nbr[1];
                if (!visited.contains(nbrNode))
                    pq.offer(new int[] { nbrNode, weight + nbrWeight });
            }
        }

        return visited.size() == n ? res : -1;
    }
}
