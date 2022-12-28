class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        
        for(int el: piles) {
            pq.add(el);
            res += el;
        }
        
        while(k-- > 0) {
            int el = pq.poll();
            pq.add(el - (el / 2));
            res -= el / 2;
        }
        
        return res;
    }
}