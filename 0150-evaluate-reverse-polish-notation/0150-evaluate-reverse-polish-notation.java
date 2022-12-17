class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = new HashSet<>(Arrays.asList("*", "/", "+", "-"));
        
        for(String token: tokens) {
            if(!ops.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int a = stack.pop(), b = stack.pop();
                int result = switch (token) {
                    case "+" -> b + a;
                    case "-" -> b - a;
                    case "*" -> a * b;
                    case "/" -> b / a;
                    default  -> 0;
                };
                stack.push(result);
            }
        }
        
        return stack.peek();
    }
}