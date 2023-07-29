class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }
        
        Map<String, Boolean> memo = new HashMap<>();
        return f(s1, s2, s3, memo, 0, 0, 0);
    }
    
    private boolean f(String s1, String s2, String s3, Map<String, Boolean> memo, int i, int j, int k) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (i == len1 && j == len2 && k == len3)
            return true;
        
        String key = i + "-" + j + "-" + k;
        if (memo.containsKey(key))
            return memo.get(key);
            
        boolean res = false;
        if (i < len1 && k < len3 && s3.charAt(k) == s1.charAt(i)) {
            res = f(s1, s2, s3, memo, i + 1, j, k + 1);
        }
        
        if (!res && j < len2 && k < len3 && s3.charAt(k) == s2.charAt(j)) {
            res = f(s1, s2, s3, memo, i, j + 1, k + 1);
        }
        
        memo.put(key, res);
        return res;
    }
}
