class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int n = s.length();
        int freq[] = new int[26];
        for (int idx = 0; idx < n; idx++) {
            freq[s.charAt(idx) - 'a']++;
            freq[t.charAt(idx) - 'a']--;
        }
        
        for (int el: freq) 
            if (el != 0) return false;
                
        return true;
    }
}