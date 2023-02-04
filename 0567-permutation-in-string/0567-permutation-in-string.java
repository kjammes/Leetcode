class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            int freq = 0;
            if (map.containsKey(c)) {
                freq = map.get(c);
            }
            freq++;
            map.put(c, freq);
        }
        
        int left = 0, right = s1.length() - 1;
        while(left < s2.length() && right < s2.length()) {
            Map<Character, Integer> temp = new HashMap<>();
            int pointer = left;
            while (pointer < s2.length() && pointer <= right) {
                char cur = s2.charAt(pointer);
                int curFreq = 0;
                if (temp.containsKey(cur)) {
                    curFreq = temp.get(cur);
                }
                curFreq++;
                temp.put(cur, curFreq);
                pointer++;
            }
            
            left++;
            right++;
            
            if (map.size() != temp.size())
                continue;
            
            boolean allMatching = true;
            for (Character c: map.keySet()) {
                if ( !temp.containsKey(c) || !temp.get(c).equals(map.get(c)) ) {
                    allMatching = false;
                    break;
                }
            }
            
            if (allMatching)
                return true;
            
        }
        
        return false;
    }
}