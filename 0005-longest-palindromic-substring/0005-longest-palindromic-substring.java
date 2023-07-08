class Solution {
//     public String longestPalindrome(String s) {
//         int start = 0, end = 0;
//         int longest = 0;
        
//         for (int i = 0; i < s.length(); i++) {
//             int left = i - 1; 
//             while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) { i++; }
            
//             int right = i + 1;
//             while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                 left--; right++;
//             }
            
//             if (right - left > longest) {
//                 longest = right - left;
//                 start = left + 1;
//                 end = right;
//             }
//         }
        
//         return s.substring(start, end);
//     }
    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0, right = 1, max = 0;

        var isPalindrome = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }

                if (isPalindrome[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }
        }

        return s.substring(left, right);
    }
}