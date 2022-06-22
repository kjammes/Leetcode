class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, (a, b) -> b - a);
        for(int el: nums)
            pq.add(el);
        
        for(int i = 0; i < nums.length; i++) {
            if(--k == 0)
                return pq.poll();
            pq.poll();
        }
        return pq.poll();
    }
}