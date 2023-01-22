class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        f(s, res, cur, 0);
        return res;
    }
    
    private void f(String s, List<List<String>> res, List<String> cur, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList(cur));
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            if (!isPalindrome(s, idx, i))
                continue;
            cur.add(s.substring(idx, i+1));
            f(s, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        
        return true;
    }
}