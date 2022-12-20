class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            int el = q.poll();
            for(int roomNo : rooms.get(el)) {
                if(!visited.contains(roomNo)) 
                    q.add(roomNo);
                
            }
            visited.add(el);
        }
        
        return visited.size() == rooms.size();
    }
}