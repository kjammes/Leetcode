class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int longest = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longest) {
                    longest = len;
                    start = left; end = right;
                }
                left--; right++;
            }
            
            left = i; right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longest) {
                    longest = len;
                    start = left; end = right;
                }
                left--; right++;
            }
        }
        
        return s.substring(start, end + 1);
    }
}