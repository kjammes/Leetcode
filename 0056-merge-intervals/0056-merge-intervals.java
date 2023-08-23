class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            int curLen = mergedIntervals.size();
            if (mergedIntervals.isEmpty() || mergedIntervals.get(curLen - 1)[1] < intervals[i][0]) 
                mergedIntervals.add(intervals[i]);
            else
                mergedIntervals.get(curLen - 1)[1] = Math.max(mergedIntervals.get(curLen - 1)[1], intervals[i][1]);
        }
        
        int[][] res = new int[mergedIntervals.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = mergedIntervals.get(i);
        }
        
        return res;
    }
}