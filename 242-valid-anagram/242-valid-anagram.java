class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        
        Map<Character, Integer> sChars = new HashMap<>();
        for(char el: s.toCharArray()) {
            int count = 0;
            
            if(sChars.containsKey(el)) 
                count = sChars.get(el) + 1;
            
            sChars.put(el, count);
        }
        
        Map<Character, Integer> tChars = new HashMap<>();
        for(char el: t.toCharArray()) {
            int count = 0;
            
            if(tChars.containsKey(el)) 
                count = tChars.get(el) + 1;
            
            tChars.put(el, count);
        }
        
        for (Map.Entry<Character,Integer> mapElement : sChars.entrySet()) {
            char key = mapElement.getKey();
            int value = mapElement.getValue();
            
            if(!tChars.containsKey(key))
                return false;
            
            int tValue = tChars.get(key);
            
            if(value != tValue) 
                return false;
        }
        
        return true;
    }
}