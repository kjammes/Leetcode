class Solution {
    public int numWays(String[] words, String target) {
        int wLen = words[0].length();
        int tLen = target.length();
        int mod = 1000000007;
        int[] dp = new int[tLen+1];
        dp[0] = 1;
        
        int[][] count = new int[wLen][26];
        for (String word: words) {
            for (int i = 0; i < wLen; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        

        for (int i = 0; i < wLen; i++) {
            for (int j = tLen - 1; j >= 0; j--) {
                dp[j + 1] += (int)((long)dp[j] * count[i][target.charAt(j) - 'a']  % mod);
                dp[j+1] %= mod;
            }
        }

        return dp[tLen];
    }
}