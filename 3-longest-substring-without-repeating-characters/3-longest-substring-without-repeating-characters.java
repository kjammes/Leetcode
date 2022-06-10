class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        
        if(len <= 1)
            return len;
        
        int left = 0, right = 0;
        int longest = 0;
        int[] nextInd = new int[128];
        
        while(right < len) {
            left = Math.max(left, nextInd[s.charAt(right)]);
            longest = Math.max(longest, right - left + 1);
            nextInd[s.charAt(right)] = right + 1;
            right++;
        }
        
        return longest;
    }
}