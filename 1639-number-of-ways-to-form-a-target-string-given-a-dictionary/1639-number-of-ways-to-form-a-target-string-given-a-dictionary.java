class Solution {

    long mod = 1000000000 + 7;
    int dp[][];
    int wordLen;
    int targetLen;

    public int numWays(String[] words, String target) {
        wordLen = words[0].length();
        targetLen = target.length();
        dp = new int[wordLen][targetLen];
        for (int i = 0; i < wordLen; i++)
            Arrays.fill(dp[i], -1);

        Map<String, Integer> cnt = new HashMap<>();
        for (String word: words) {
            for (int i = 0; i < wordLen; i++) {
                String key = String.valueOf(i + "_" + word.charAt(i));
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }
        }
        
        return f(words, target, 0, 0, cnt);
    }

    private int f(String[] words, String target, int wIdx, int tIdx, Map<String, Integer> cnt) {
        if (tIdx == targetLen)
            return 1;

        if (wIdx == wordLen)
            return 0;

        if (dp[wIdx][tIdx] != -1)
            return dp[wIdx][tIdx];

        long result = f(words, target, wIdx + 1, tIdx, cnt);
        String key = String.valueOf(wIdx + "_" + target.charAt(tIdx));
        result += ((long) cnt.getOrDefault(key, 0) * f(words, target, wIdx + 1, tIdx + 1, cnt));

        dp[wIdx][tIdx] = (int) (result % mod);
        return dp[wIdx][tIdx];
    }
}