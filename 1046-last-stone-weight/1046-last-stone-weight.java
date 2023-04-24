class Solution {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 0 || len == 1)
            return len;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int el: stones) 
            maxHeap.offer(el);
        
        while (!maxHeap.isEmpty() && maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            
            if (x == y)
                continue;
            
            maxHeap.offer(x - y);
        }
        
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}