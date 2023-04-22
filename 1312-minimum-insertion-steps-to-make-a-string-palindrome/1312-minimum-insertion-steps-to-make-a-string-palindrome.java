class Solution {
    public int minInsertions(String s) {
        StringBuilder reverse = new StringBuilder(s);
        reverse = reverse.reverse();

        return  s.length() - lcs(s, reverse);
    }

    private int lcs(String s, StringBuilder rev) {
        int len = s.length();

        int[] cur = new int[len + 1];
        int[] prev = new int[len + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >=0; j--) {
                char sChar = s.charAt(j);
                char rChar = rev.charAt(i);
                if (sChar == rChar) 
                    cur[j] = prev[j+1] + 1;
                else
                    cur[j] = Math.max(cur[j+1], prev[j]);
            }
            prev = cur.clone();
            cur = new int[len + 1];
        }

        return prev[0];
    }

}