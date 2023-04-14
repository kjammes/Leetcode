class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        return lcs(s, sb.reverse().toString());
    }

    private int lcs(String s, String t) {
        int len = s.length();
        int memo[][] = new int[len + 1][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j))
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                else
                    memo[i][j] = Math.max(memo[i+1][j], memo[i][j+1]);
            }
        }

        return memo[0][0];
    }
}