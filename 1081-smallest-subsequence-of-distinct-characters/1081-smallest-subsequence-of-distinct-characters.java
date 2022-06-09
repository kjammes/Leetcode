class Solution {
    public String smallestSubsequence(String s) {
        
        if(s.length() <= 1 || s == null)
            return s;
        
        Stack<Integer> stack = new Stack<>();
        
        int[] visited = new int[26], last = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            
            if(visited[c]++ > 0) continue;
            
            while(!stack.isEmpty() && stack.peek() > c && last[stack.peek()] > i)
                visited[stack.pop()] = 0;
                
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int el: stack) { sb.append( (char) (el + 'a') ); }
        
        return sb.toString();
    }
}