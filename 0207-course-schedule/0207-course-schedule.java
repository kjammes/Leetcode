class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            adj[pair[0]].add(pair[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, adj, visited, stack)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, List<Integer>[] adj, boolean[] visited, boolean[] stack) {
        visited[node] = true;
        stack[node] = true;
        for (int n: adj[node]) {
            if (!visited[n] && hasCycle(n, adj, visited, stack))
                return true;
            else if (stack[n])
                return true;
        }
        stack[node] = false;
        return false;
    }
}
