class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res = new int[n];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int el[]: edges) {
            graph.get(el[0]).add(el[1]);
            graph.get(el[1]).add(el[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        f(n, graph, labels, visited, 0, res);
        
        return res;
    }
    
    private int[] f(int n, List<List<Integer>> graph, String labels, boolean[] visited, int node, int[] result) {
        visited[node] = true;
        int[] count = new int[26];
        
        for(int child: graph.get(node)) {
            if (visited[child])
                continue;
            
            int[] rCount = f(n, graph, labels, visited, child, result);
            
            for(int i = 0; i < 26; i++) {
                count[i] += rCount[i];
            }
        }
        
        char c = labels.charAt(node);
        count[c - 'a'] += 1;
        
        result[node] = count[c - 'a'];
        
        return count;
    }
}