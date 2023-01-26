class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        int[] temp  = new int[n];
        
        for(int i = 0; i < n; i++) {
            costs[i] = Integer.MAX_VALUE;
            temp[i]  = Integer.MAX_VALUE;
        }
        
        costs[src] = 0;
        temp[src]  = 0;
        
        for(int i = 0; i < k+1; i++) {
            for(int[] flight: flights) {
                
                int start = flight[0];
                int end   = flight[1];
                int cost  = flight[2];
                
                int startCost = costs[start];
                if (startCost == Integer.MAX_VALUE)
                    continue;
                
                int endCost = startCost + cost;
                temp[end] = Math.min(temp[end], endCost);
            }
            for(int j = 0; j < n; j++) {
                costs[j] = temp[j];
            }
        }
        
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
    
}