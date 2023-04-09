class GraphNode {
    int val;
    List<Integer> neighbors;

    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public void addNodes(int val) {
        this.neighbors.add(val);
    }
}

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int m = edges.length;
        GraphNode graph[] = new GraphNode[n];
        for (int i = 0; i < n; i++)
            graph[i] = new GraphNode(i);

        int[] indegree = new int[n];
        for (int[] edge: edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].addNodes(dest);
            indegree[dest]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if ( indegree[i] == 0 ) 
                q.add(i);
            count[i][colors.charAt(i) - 'a'] = 1;
        }

        int visits = 0;
        int res = 0;

        while (!q.isEmpty()) {
            int curNode = q.poll();
            visits++;
            for (int neighbor: graph[curNode].neighbors) {
                for (int i = 0; i < 26; i++) {
                    count[neighbor][i] = Math.max(
                        count[neighbor][i],
                        count[curNode][i] + (colors.charAt(neighbor) - 'a' == i ? 1 : 0)
                    );
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
            res = Math.max(res, Arrays.stream(count[curNode]).max().getAsInt());
        }

        return visits == n ? res : -1;
    }
}