class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int minValue=Integer.MAX_VALUE;
        for (int el: nums) {
            if (el % 2 != 0)
                el *= 2;
            pq.add(el);
            minValue = Math.min(minValue, el);
        }
        int result = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int el = pq.poll();
            result = Math.min(result, el - minValue);
            if (el % 2 != 0)
                break;
            el /= 2;
            minValue = Math.min(minValue, el);
            pq.add(el);
        }
        
        return result;
    }
}