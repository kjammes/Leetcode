class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] indegree = new boolean[n];
        for (List<Integer> edge: edges) {
            indegree[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!indegree[i])
                res.add(i);
        }

        return res;
    }
}