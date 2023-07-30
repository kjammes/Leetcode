class Solution {
    
    int sLen, tLen;
    
    public int numDistinct(String s, String t) {
        sLen = s.length(); tLen = t.length();
        if (tLen > sLen)
            return 0;
        if (tLen == sLen)
            return s.equals(t) ? 1 : 0;
        int[][] dp = new int[sLen][tLen];
        for (int r[]: dp)
            Arrays.fill(r, -1);
        return f(s, t, 0, 0, dp);
    }
    
    private int f(String s, String t, int idxS, int idxT, int[][] dp) {
        if (idxT == tLen)
            return 1;
        
        if (idxS >= sLen || idxT >= tLen)
            return 0;
        
        if (dp[idxS][idxT] != -1)
            return dp[idxS][idxT];
        
        int skip = f(s, t, idxS + 1, idxT, dp);
        int choose = 0;
        if (s.charAt(idxS) == t.charAt(idxT)) 
            choose = f(s, t, idxS + 1, idxT + 1, dp);
        
        dp[idxS][idxT] = skip + choose;
        return dp[idxS][idxT];
    }
}