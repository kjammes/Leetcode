class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> q = new Stack<>();
        q.push(0);
        
        while(!q.empty()) {
            int el = q.pop();
            for(int roomNo : rooms.get(el)) {
                if(!visited.contains(roomNo)) 
                    q.push(roomNo);
                
            }
            visited.add(el);
        }
        
        return visited.size() == rooms.size();
    }
}