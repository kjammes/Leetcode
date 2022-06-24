class Solution {
//     public boolean isPossible(int[] target) {
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(target.length, (a, b) -> b - a);
//         int sum = 0;
//         for(int el: target) {
//             maxHeap.add(el);
//             sum += el;
//         }
        
//         while (maxHeap.peek() != 1) {
// 		    int curr = maxHeap.poll();
// 		    if(sum - curr == 1) return true;

// 		    int x = curr % (sum - curr);
//             System.out.println("x("+ x +") = curr("+ curr +") % (sum("+ sum +") - curr("+ curr +"))");
// 		    sum = sum - curr + x;
//             System.out.println("sum = " + sum);

// 		    if (x == 0 || x == curr) return false;
// 		    else maxHeap.add(x);
// 	    }

// 	    return true;
//     }
    
    public boolean isPossible(int[] target) {
	if (target.length == 1) return target[0] == 1;

	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	int sum = 0;
	for (int t: target) {
		pq.add(t);
		sum += t;
	}

	while (pq.peek() != 1) {
		int curr = pq.poll();
		if (sum - curr == 1) return true;

		int x = curr % (sum - curr);
		sum = sum - curr + x;

		if (x == 0 || x == curr) return false;
		else pq.add(x);
	}

	return true;
}
}