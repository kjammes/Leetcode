class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        f(res, n, 0, 0, "");
        return res;
    }
    
    private void f(List<String> res, int n, int left, int right, String str) {
        if (left + right == n * 2) {
            res.add(str);
            return;
        }
        
        if (left < n) {
            f(res, n, left + 1, right, str + '(');
        }
        
        if (right < left) {
            f(res, n, left, right + 1, str + ')');
        }
    }
}