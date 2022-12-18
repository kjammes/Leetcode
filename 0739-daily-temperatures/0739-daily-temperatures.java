class Solution {
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        
        if(len == 1) 
            return new int[] {0};
        
        int result[] = new int[len];
        Stack<Integer> s = new Stack<>();
        for(int i = len - 1; i >= 0; i--) {
            while(!s.empty() && t[i] >= t[s.peek()]) {
                s.pop();
            }
            
            if(!s.empty())
                result[i] = s.peek() - i;
            
            s.push(i);
        }
        
        return result;
    }
}