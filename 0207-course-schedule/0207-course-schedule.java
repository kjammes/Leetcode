import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] el : prerequisites) {
            indegree[el[0]]++;
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

            for (int[] el : prerequisites) {
                if (el[1] == node) {
                    indegree[el[0]]--;
                    if (indegree[el[0]] == 0)
                        q.offer(el[0]);
                }
            }
        }

        return count == numCourses;
    }
}
