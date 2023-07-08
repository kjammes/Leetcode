public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String processedString = preprocessString(s);
        int n = processedString.length();
        int[] palindromeLengths = new int[n];
        int center = 0;
        int right = 0;
        int maxLen = 0;
        int maxCenter = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                palindromeLengths[i] = Math.min(right - i, palindromeLengths[mirror]);
            }

            while (processedString.charAt(i + 1 + palindromeLengths[i]) == processedString.charAt(i - 1 - palindromeLengths[i])) {
                palindromeLengths[i]++;
            }

            if (i + palindromeLengths[i] > right) {
                center = i;
                right = i + palindromeLengths[i];
            }

            if (palindromeLengths[i] > maxLen) {
                maxLen = palindromeLengths[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLen) / 2;
        int end = start + maxLen;

        return s.substring(start, end);
    }

    private String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append('#').append('$');
        return sb.toString();
    }
}
