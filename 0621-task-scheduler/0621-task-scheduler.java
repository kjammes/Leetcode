class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char el: tasks)
            freq[el - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int f: freq)
            if (f != 0) pq.offer(f);
        
        Queue<int[]> q = new LinkedList<>();
        
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            
            if (!pq.isEmpty()) {
                int newFreq = pq.poll() - 1;
                if (newFreq != 0)
                    q.offer(new int[] {newFreq, time + n});
            }
            
            if (!q.isEmpty() && time == q.peek()[1]) {
                pq.offer(q.poll()[0]);
            }
        }
        
        return time;
    }
}