class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int pointer = 0;
        
        for (int el: pushed) {
            stack.push(el);
            while ( 
                !stack.isEmpty() && 
                stack.peek() == popped[pointer]
            ) {
                stack.pop();
                pointer++;
            }
        }
        
        return stack.isEmpty();
    }
}