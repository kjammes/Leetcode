class Solution {
    public int minJumps(int[] arr) {
        int len = arr.length;
        
        if (len == 1)
            return 0;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[len];
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int el = q.poll();
                if (el == len - 1)
                    return steps;
                
                List<Integer> jumpIdxs = graph.get(arr[el]);
                jumpIdxs.add(el - 1);
                jumpIdxs.add(el + 1);
                for(int jumpIdx: jumpIdxs) {
                    if (jumpIdx < 0 || jumpIdx >= len || visited[jumpIdx])
                        continue;
                    q.offer(jumpIdx);
                    visited[jumpIdx] = true;
                }
                jumpIdxs.clear();
            }
            steps++;
        }
        
        return steps;
    }
}