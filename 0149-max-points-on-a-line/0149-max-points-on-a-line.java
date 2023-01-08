class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if( n == 1) return 1;
        int max = 2;
        for(int i=0; i<n-1; i++){
            Map<Double, Integer> tangentMap = new HashMap<>();
            for(int j=0; j<n; j++){
                if(i == j)
                    continue;
                
                int[] p1 = points[i];
                int[] p2 = points[j];
                int x1 = p1[0];
                int y1 = p1[1];
                int x2 = p2[0];
                int y2 = p2[1];
                
                double tangent = Math.atan2((y2-y1),(x2-x1));
                int c = tangentMap.getOrDefault(tangent, 0);
                tangentMap.put(tangent, c+1);
            }

            max = Math.max(max, Collections.max(tangentMap.values())+1);
        }
        
        return max;
    }
}