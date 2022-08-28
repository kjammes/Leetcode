class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String el: strs) {
            char[] ca = new char[26];
            for(char c: el.toCharArray()) ca[c - 'a']++;
            String s = String.valueOf(ca);
            if(!map.containsKey(s))
                map.put(s, new ArrayList<>());
            map.get(s).add(el);
        }
        
        return new ArrayList<>(map.values());
    }
}