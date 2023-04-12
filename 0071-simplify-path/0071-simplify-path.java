class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");

        int tokensLen = tokens.length;
        if (tokensLen == 0)
            return "/";

        StringBuilder sb = new StringBuilder('/');
        Stack<String> stack = new Stack<>();
        for (String token: tokens) {
            if (!stack.isEmpty() && token.equals(".."))
                stack.pop();
            else if (!token.equals(".") && !token.equals("..") && !token.equals(""))
                stack.push(token);
        }

        if (stack.isEmpty())
            return "/";

        while (!stack.isEmpty())
            sb.insert(0, stack.pop()).insert(0, "/");

        return sb.toString();
    }
}