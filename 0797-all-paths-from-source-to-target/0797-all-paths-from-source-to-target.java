class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        int target = graph.length - 1;
        List<Integer> curPath = new ArrayList<>();
        curPath.add(0);
        dfs(graph, paths, target, 0, curPath);
        return paths;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> paths, int target, int el, List<Integer> curPath) {
        if(el == target) {
            paths.add(new ArrayList(curPath));
            return;
        }
        
        for(int childNode: graph[el]) {
            curPath.add(childNode);
            dfs(graph, paths, target, childNode, curPath);
            curPath.remove(curPath.size() - 1);
        }
    }
}