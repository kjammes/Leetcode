class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String idea: ideas) {
            Character c = idea.charAt(0);
            Set<String> set;
            if (map.containsKey(c)) {
                set = map.get(c);
            } else {
                set = new HashSet<>();
            }
            set.add(idea.substring(1));
            map.put(c, set);
        }
        
        long result = 0;
        for (Character c1: map.keySet()) {
            for (Character c2: map.keySet()) {
                if (c1.equals(c2))
                    continue;
                int common = 0;
                Set<String> s1 = map.get(c1);
                Set<String> s2 = map.get(c2);
                for (String el: s1) {
                    if (s2.contains(el))
                        common++;
                }
                result += (s1.size() - common) * (s2.size() - common);
            }
        }
        
        return result;
    }
}