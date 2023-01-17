class Solution {
    public int minFlipsMonoIncr(String s) {
        int zeros = 0;
        int ones  = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '0')
                zeros++;
        }
        
        int result = zeros;
        for(char c: s.toCharArray()) {
            if (c == '0') {
                zeros--;
            } else {
                ones++;
            }
            result = Math.min(result, zeros + ones);
        }
        
        return result;
    }
}