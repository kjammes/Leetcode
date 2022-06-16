class Solution {
    
    public String longestPalindrome(String s) {
        int finalI = 0, finalJ = 0;
      
        int maxLen = 0;
        for(int ind=0;ind<s.length();ind++){
            int i = ind, j = ind;
            while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
              if((j - i + 1) > maxLen) {
                maxLen = (j - i + 1);
                finalI = i;
                finalJ = j;
              }
              j++;
              i--;
            }
          
            i = ind;
            j = ind + 1;
            while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
              if((j - i + 1) > maxLen) {
                maxLen = (j - i + 1);
                finalI = i;
                finalJ = j;
              }
              j++;
              i--;
            }
        }
        return s.substring(finalI, finalJ + 1);
    }
}