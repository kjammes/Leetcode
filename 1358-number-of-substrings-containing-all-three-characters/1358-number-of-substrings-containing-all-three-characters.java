class Solution {
    public int numberOfSubstrings(String s) {
        int count[] = {0, 0, 0};
        int p = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) 
                count[s.charAt(p++) - 'a']--;
            res += p;
        }
        return res;
    }
}