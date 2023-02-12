class Solution {
    long res = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int road[]: roads) {
            int x = road[0];
            int y = road[1];
            List<Integer> list = new ArrayList<>();
            
            if (graph.containsKey(x))
                list = graph.get(x);
            list.add(y);
            graph.put(x, list);
            
            list = new ArrayList<>();
            if (graph.containsKey(y))
                list = graph.get(y);
            list.add(x);
            graph.put(y, list);
        }
        
        dfs(0, -1, seats, graph);
        
        return res;
    }
    
    private long dfs(int node, int parent, int seats, Map<Integer, List<Integer>> graph) {
        long passengers = 0;
        for (int child: graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent)
                continue;
            long p = dfs(child, node, seats, graph);
            passengers += p;
            res += Math.ceil(p * 1.0 / seats);
        }
        return passengers + 1;
    }
}