class Solution {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int[] point: points) { pQ.add(point); }
        
        if(pQ.isEmpty()) return result;
        
        while(!pQ.isEmpty()) {
            int[] prev = pQ.poll();
            
            while(!pQ.isEmpty() && pQ.peek()[0] <= prev[1] && prev[1] <= pQ.peek()[1] ) { pQ.poll(); }
            
            result++;
        }
        
        return result;
    }
}