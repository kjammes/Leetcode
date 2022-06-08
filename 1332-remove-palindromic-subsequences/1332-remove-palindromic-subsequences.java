class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0; // This is the situation #1.
        }
        
        int left  = 0;
        int right = s.length()-1;
        
        int res = 0;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else
                return 2;
        }
        
        return 1;
    }
}