class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int[] interval: intervals) {
            int low = interval[0];
            int high = interval[1];
            
            int newLow = newInterval[0];
            int newHigh = newInterval[1];
            
            if (high < newLow) {
                res.add(Arrays.asList(low, high));
            } else if (newHigh < low) {
                res.add(Arrays.asList(newLow, newHigh));
                newInterval[0] = low;
                newInterval[1] = high;
            } else {
                newInterval[0] = Math.min(low, newLow);
                newInterval[1] = Math.max(high, newHigh);
            }
        }
        
        res.add(Arrays.asList(newInterval[0], newInterval[1]));
        
        return res.stream()
            .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);
    }
}