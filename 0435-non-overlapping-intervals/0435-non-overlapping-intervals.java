class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0; // No overlaps if there's only one or zero intervals
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int count = 1; // Count of non-overlapping intervals

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // Non-overlapping interval found
                end = intervals[i][1];
                count++;
            }
            // Otherwise, the current interval overlaps, so it can be skipped
        }

        // The number of intervals to be removed = Total intervals - Non-overlapping intervals
        return intervals.length - count;
    }
}
