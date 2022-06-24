class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(target.length, (a, b) -> b - a);
        int sum = 0;
        for(int el: target) {
            maxHeap.add(el);
            sum += el;
        }
        
        while (maxHeap.peek() != 1) {
		    int curr = maxHeap.poll();
		    if(sum - curr == 1) return true;

		    int x = curr % (sum - curr);
		    sum = sum - curr + x;

		    if (x == 0 || x == curr) return false;
		    else maxHeap.add(x);
	    }

	    return true;
    }

}