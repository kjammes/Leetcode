import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] el : prerequisites) {
            int course = el[0];
            int prerequisite = el[1];
            adj.putIfAbsent(prerequisite, new ArrayList<>());
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            if (adj.containsKey(node)) {
                for (int course : adj.get(node)) {
                    indegree[course]--;
                    if (indegree[course] == 0)
                        q.offer(course);
                }
            }
        }

        return count == numCourses;
    }
}
