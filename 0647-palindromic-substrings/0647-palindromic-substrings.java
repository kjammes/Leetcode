class Solution {
//     public int countSubstrings(String s) {
//         int res = 0;
//         for (int i = 0; i < s.length(); i++) {
//             int left = i, right = i;
//             while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) { res++; }
            
//             left = i; right = i + 1;
//             while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) { res++; }
//         }
//         return res;
//     }
    public int countSubstrings(String s) {
        
        int len = s.length();
        
        var dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        
        int res = len;
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                continue;
            dp[i][i+1] = true;
            res++;
        }
            
        
        for (int sze = 2; sze < len; sze++) {
            for (int i = 0; i + sze < len; i++) {
                int j = i + sze;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    res++;
                    dp[i][j] = true;
                }
            } 
        }
        
        return res;
    }
}