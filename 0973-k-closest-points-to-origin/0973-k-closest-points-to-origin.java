class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length - 1;
        
        while (left <= right) {
            int pivotIndex = partition(points, left, right);
            
            if (pivotIndex == K) {
                break;
            } else if (pivotIndex < K) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[left];
        
        while (left < right) {
            while (left < right && compare(points[right], pivot) >= 0) {
                right--;
            } 
            points[left] = points[right];
            
            while (left < right && compare(points[left], pivot) <= 0) {
                left++;
            }
            points[right] = points[left];
        }
        
        points[left] = pivot;
        return left;
    }
    
    private int compare(int[] point1, int[] point2) {
        return point1[0] * point1[0] + point1[1] * point1[1] -
               point2[0] * point2[0] - point2[1] * point2[1];
    }
}
