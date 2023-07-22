class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) { adj[i] = new ArrayList<>(); }
        for (int[] el: prerequisites) {
            adj[el[0]].add(el[1]);
        }
        
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int child: adj[i])
                indegree[child]++;
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
            
            for (int child: adj[node]) {
                indegree[child]--;
                if (indegree[child] == 0)
                    q.offer(child);
            }
        }
        
        System.out.println("topo.size() : " + topo.size());
        return topo.size() == numCourses;
    }
}