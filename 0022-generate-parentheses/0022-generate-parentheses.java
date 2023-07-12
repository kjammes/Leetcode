class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        f(res, n, 0, 0, new StringBuilder());
        return res;
    }
    
    private void f(List<String> res, int n, int left, int right, StringBuilder sb) {
        if (left + right == n * 2) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append('(');
            f(res, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right < left) {
            sb.append(')');
            f(res, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
