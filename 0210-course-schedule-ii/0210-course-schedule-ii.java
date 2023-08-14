class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        
        int[] indegree = new int[numCourses];
        for (int[] preq: prerequisites) {
            int pre = preq[1];
            int course = preq[0];
            graph[pre].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < numCourses; node++) {
            if (indegree[node] == 0)
                q.offer(node);
        }
        
        int cnt = 0;
        int[] result = new int[numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            result[cnt++] = node;
            
            for (int ng: graph[node]) {
                indegree[ng]--;
                if (indegree[ng] == 0)
                    q.offer(ng);
            }
        }
        return cnt == numCourses ? result : new int[] {};
    }
}