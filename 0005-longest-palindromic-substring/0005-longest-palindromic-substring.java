class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int longest = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1; 
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) { i++; }
            
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            
            if (right - left > longest) {
                longest = right - left;
                start = left + 1;
                end = right;
            }
        }
        
        return s.substring(start, end);
    }
}