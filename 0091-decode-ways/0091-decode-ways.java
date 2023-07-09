class Solution {
    
    public int numDecodings(String s) {
        return f(s, 0, new Integer[s.length()]);
    }
    
    private Integer f(String s, int idx, Integer[] dp) {
        if (idx == s.length()) {
            return 1;
        }
        
        if (s.charAt(idx) == '0')
            return 0;
        
        if (dp[idx] != null)
            return dp[idx];
        
        int count = 0;
        count += f(s, idx + 1, dp);
        if (
            idx + 1 < s.length() &&
            ( s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7' )
        ) {
            count += f(s, idx + 2, dp);
        }
        dp[idx] = count;
        return count;
    }
}