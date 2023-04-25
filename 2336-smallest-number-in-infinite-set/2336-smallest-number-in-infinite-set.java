class SmallestInfiniteSet {

    PriorityQueue<Integer> minHeap;
    int[] map;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        map = new int[1001];
        for (int i = 1; i<= 1000; i++) {
            minHeap.offer(i);
            map[i] = 1;
        }
    }
    
    public int popSmallest() {
        int res = minHeap.poll();
        map[res] = 0;
        return res;
    }
    
    public void addBack(int num) {
        if (map[num] != 0)
            return;
        minHeap.offer(num);
        map[num] = 1;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */