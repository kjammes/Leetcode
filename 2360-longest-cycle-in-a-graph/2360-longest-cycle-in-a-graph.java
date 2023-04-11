class Solution {
    public int longestCycle(int[] edges) {
        int len = edges.length;
        
        int[] visitedTime = new int[len];
        int time = 1;
        int res = -1;
        for (int node = 0; node < len; node++) {
            if (visitedTime[node] > 0)
                continue;
            
            int curNode = node;
            final int startTime = time;
            while (curNode != -1 && visitedTime[curNode] == 0) {
                visitedTime[curNode] = time++;
                curNode = edges[curNode];
            }
            
            if (curNode != -1 && visitedTime[curNode] >= startTime)
                res = Math.max(res, time - visitedTime[curNode]);
        }

        return res;
    }
}
