class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if (
            maxHeap.size() - minHeap.size() > 1 ||
            !minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()
        )
            minHeap.offer(maxHeap.poll());
        
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