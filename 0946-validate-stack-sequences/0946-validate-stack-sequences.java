class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int pushP = 0, popP = 0;
        
        while (pushP < len) {
            stack.push(pushed[pushP++]);
            
            int el = stack.peek();
            while (popP < len && el == popped[popP]) {
                stack.pop();
                popP++;
                if (!stack.isEmpty())
                    el = stack.peek();
            }
        }
        
        System.out.println(stack);
        System.out.println(popP);
        while (popP < len && !stack.isEmpty()) {
            int el = stack.pop();
            System.out.println("el : " + el);
            System.out.println("popped[popP] : " + popped[popP]);
            if (el != popped[popP])
                return false;
            popP++;
        }
        
        return true;
    }
}