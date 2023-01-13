class Solution {
    
    int res = 1;
    
    public int longestPath(int[] parent, String s) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 1; i < parent.length; i++){
            int j = parent[i];
            adj.putIfAbsent(j, new LinkedList<>());
            adj.get(j).add(i);
        }
        dfs(0, adj, s);
        return res;
    }
    
    private int dfs(int node, Map<Integer, List<Integer>> graph, String s) {
        if (!graph.containsKey(node)) 
            return 1;
        
        int max = 0, secondMax = 0;
        for(int child: graph.get(node)) {
            
            int longestChildPath = dfs(child, graph, s);
            
            if (s.charAt(child) == s.charAt(node))
                continue;
            
            if(longestChildPath > max) {
                secondMax = max;
                max = longestChildPath;
            } else if (longestChildPath > secondMax) {
                secondMax = longestChildPath;
            }
        }
        
        res = Math.max(res, max + secondMax + 1);
        
        return max + 1;
    }
}