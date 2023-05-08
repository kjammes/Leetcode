class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int start = 0;
        int len = s.length();

        int res = 0;
        int longest = 0;
        for (int end = 0; end < len; end++) {
            map[s.charAt(end) - 'A']++;
            longest = Math.max(longest, map[s.charAt(end) - 'A']);
            int windowSize = (end - start + 1);
            while (windowSize - longest > k) {
                map[s.charAt(start) - 'A']--;
                start++;
                windowSize = (end - start + 1);
            }

            res = Math.max(res, windowSize);
        }

        return res;
    }
}