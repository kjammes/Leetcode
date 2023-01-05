class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int result = 1;
        
        int previous = 0;
        
        for(int cur = 1; cur < points.length; cur++) {
            if(points[previous][1] < points[cur][0]) {
                result++;
                previous = cur;
            }
        }
        
        return result;
    }
}