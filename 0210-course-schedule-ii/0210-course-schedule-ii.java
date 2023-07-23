class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) { adj[i] = new ArrayList<>(); }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int prerequisite = prerequisites[i][1];
            int course = prerequisites[i][0];

            adj[prerequisite].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int n: adj[node]) {
                indegree[n]--;
                if (indegree[n] == 0)
                    q.offer(n);
            }
        }
        
        return topo.size() == numCourses ? 
            topo.stream().mapToInt(Integer::intValue).toArray() : new int[] {};
    }
}