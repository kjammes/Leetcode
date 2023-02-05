class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        int sLen = s.length();
        int pLen = p.length();
        
        if (pLen > sLen)
            return result;
        
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        
        for (int i = 0; i < pLen; i++) {
            sFreq[s.charAt(i) - 'a']++;
            pFreq[p.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++)
            matches += sFreq[i] == pFreq[i] ? 1 : 0;
        
        int left = 0;
        for(int right = pLen; right < sLen; left++, right++) {
            if (matches == 26)
                result.add(left);
            
            int idx = s.charAt(left) - 'a';
            sFreq[idx]--;
            if (sFreq[idx] == pFreq[idx])
                matches++;
            else if (sFreq[idx] + 1 == pFreq[idx])
                matches--;
            
            idx = s.charAt(right) - 'a';
            sFreq[idx]++;
            if (sFreq[idx] == pFreq[idx])
                matches++;
            else if (sFreq[idx] - 1 == pFreq[idx])
                matches--;
        }
        
        if (matches == 26)
            result.add(left);
        
        return result;
    }
}