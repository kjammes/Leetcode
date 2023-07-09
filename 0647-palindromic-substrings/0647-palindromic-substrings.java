class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) { res++; }
            
            left = i; right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) { res++; }
        }
        return res;
    }
}