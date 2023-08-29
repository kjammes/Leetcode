class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int qLen = queries.length;
        int iLen = intervals.length;
        
        int[] sortedQueries = new int[qLen];
        for (int i = 0; i < qLen; i++)
            sortedQueries[i] = queries[i];
        Arrays.sort(sortedQueries);
        Arrays.sort(intervals, (a, b) -> {
           if (a[0] == b[0])
               return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });
        
        // key will be query and value will be the shortest interval
        Map<Integer, Integer> resMap = new HashMap<>();
        // first element will be interval size and second will be right boundary of interval
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
           if (a[0] == b[0])
               return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });
        int idx = 0;
        
        for (int query: sortedQueries) {
            while (idx < iLen && query >= intervals[idx][0]) {
                int l = intervals[idx][0], r = intervals[idx][1];
                pq.offer(new int[] {r - l + 1, r});
                idx++;
            }
            
            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }
            if (!pq.isEmpty())
                resMap.put(query, pq.peek()[0]);
            else
                resMap.put(query, -1);
        }
        
        int[] result = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int query = queries[i];
            result[i] = resMap.get(query);
        }
        return result;
    }
}
