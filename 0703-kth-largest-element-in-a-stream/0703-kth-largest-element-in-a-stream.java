class KthLargest {
    
    final int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int el: nums)
            add(el);
    }
    
    public int add(int val) {
        if (pq.size() < k)
            pq.offer(val);
        else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */