class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        // We are basically dividing our input stream into two parts.
        // the left part will always be smaller and we will need largest from that part (maxHeap)
        // the right part will always be bigger and we will need smallest from that part (minHeap)
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        // By default offering to maxHeap
        maxHeap.offer(num);
        
        // If size difference exceeds one OR if maxHeap has element greater than minHeaps smallest 
        // we pop/poll form maxHeap and offer to minHeap
        if (
            maxHeap.size() - minHeap.size() > 1 ||
            !minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()
        )
            minHeap.offer(maxHeap.poll());
        
        // In case above operations results to a situation where difference exceeds one
        // we this time offer minHeaps max to max heap.
        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        int min = minHeap.size(), max = maxHeap.size();
        if (min == max) {
            return  (( (double) minHeap.peek() + (double) maxHeap.peek()) / 2);
        } else if (min > max) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */