class Pair {
    int[] coors;
    double distance;
    
    Pair(int[] coors, double distance) {
        this.coors = coors;
        this.distance = distance;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));
        
        for (int point[]: points) {
            double eDist = Math.sqrt(
                Math.pow(0 - point[0], 2) +
                Math.pow(0 - point[1], 2)
            );
            pq.offer(new Pair(new int[] {point[0], point[1]}, eDist));
        }
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().coors;
        }
        
        return res;
    }
}