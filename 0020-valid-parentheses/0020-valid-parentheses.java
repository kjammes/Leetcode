class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();        
        for (char bracket: s.toCharArray()) {
            if (
                bracket == '[' ||
                bracket == '{' ||
                bracket == '('
            ) {
                st.push(bracket);
                continue;
            }

            if (st.empty())
                return false;
                
            char prevBracket = st.pop();
            char compliment = '_';
            switch(bracket) {
                case ')':
                    compliment = '(';
                    break;
                case ']':
                    compliment = '[';
                    break;
                case '}':
                    compliment = '{';
                    break;
            }
            if (prevBracket != compliment)
                return false;
        }

        return st.empty();
    }
}