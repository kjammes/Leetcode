class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new LinkedList();
        int target = graph.length - 1;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));
        
        while(!q.isEmpty()) {
            List<Integer> path = q.poll();
            int curEl = path.get(path.size() - 1);
            if(curEl == target) {
                paths.add(new ArrayList(path));
            }
            
            for(int childNode: graph[curEl]) {
                List<Integer> l = new ArrayList(path);
                l.add(childNode);
                q.add(l);
            }
        }
        
        return paths;
    }
    
}