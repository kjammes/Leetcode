class Solution {
    public int minFlipsMonoIncr(String s) {
        int noOfFlips = 0, ans = 0;
        
        for(char c: s.toCharArray()) {
            if (c == '0') {
                ans = Math.min(noOfFlips, ans + 1);
            } else {
                noOfFlips++;
            }
        }
        
        return ans;
    }
}