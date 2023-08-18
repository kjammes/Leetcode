class Solution {
    public int countPaths(int n, int[][] roads) {
        final long MOD = (long)(1e9 + 7);
        
        List<Pair>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] el: roads) {
            int u = el[0];
            int v = el[1];
            int w = el[2];
            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        long[] ways = new long[n];
        ways[0] = 1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0, 0));
        
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int node = (int) top.node;
            long dis  = top.dist;
            
            for (Pair ng: graph[node]) {
                int adjNode = (int) ng.node;
                long edW = ng.dist;
                
                if (edW + dis < dist[adjNode]) {
                    dist[adjNode] = edW + dis;
                    pq.offer(new Pair(adjNode, edW + dis));
                    ways[adjNode] = ways[node];
                } else if (dis + edW == dist[adjNode]) 
                    ways[adjNode] = (ways[adjNode]  % MOD + ways[node]  % MOD) % MOD;
                    
            }
        }
        
        return (int)(ways[n-1] % MOD);
    }
}

class Pair {
    long node;
    long dist;
    
    Pair(long node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}
