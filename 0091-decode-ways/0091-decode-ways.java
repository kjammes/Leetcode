class Solution {
    
    public int numDecodings(String s) {
        // return f(s, 0, new Integer[s.length()]);
        int len = s.length();
        int dp[] = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            if (s.charAt(i - 2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7') {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[len];
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