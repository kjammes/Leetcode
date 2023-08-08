class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        for (int i = 1; i < n; i++) {
            for (int el[]: times) {
                int src = el[0], dest = el[1], time = el[2];
                if (dist[src] != Integer.MAX_VALUE && dist[src] + time < dist[dest]) 
                    dist[dest] = dist[src] + time;
            }
        }
        
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int d = dist[i];
            if (d == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, d);
        }
        
        return res;
    }
}
