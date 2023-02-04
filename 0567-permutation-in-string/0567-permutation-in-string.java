class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) 
            return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++)
            matches += s1Count[i] == s2Count[i] ? 1 : 0;
        
        int left = 0;
        for (int right = len1; right < len2; right++) {
            if (matches == 26)
                return true;
            
            int idx = s2.charAt(right) - 'a';
            s2Count[idx]++;
            if (s2Count[idx] == s1Count[idx])
                matches++;
            else if(s2Count[idx] == s1Count[idx] + 1)
                matches--;
            
            idx = s2.charAt(left++) - 'a';
            s2Count[idx]--;
            if (s2Count[idx] == s1Count[idx])
                matches++;
            else if (s2Count[idx] == s1Count[idx] - 1)
                matches--;
        }
        
        return matches == 26;
    }
}