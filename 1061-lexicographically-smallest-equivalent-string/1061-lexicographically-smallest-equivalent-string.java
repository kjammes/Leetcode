class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = s1.length();
        
        List<Set<Character>> set = new ArrayList<>();
        int currSet = 1;
        int[] sets = new int[26];
        
        for(int i=0; i<len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (c1 == c2) continue;
            
            if (sets[c1 - 'a'] == 0 && sets[c2 - 'a'] == 0) {
                Set<Character> cSet = new TreeSet<>();
                cSet.add(c1);
                cSet.add(c2);
                set.add(cSet);
                sets[c1 - 'a'] = currSet;
                sets[c2 - 'a'] = currSet;
                currSet++;
            } else if (sets[c1 - 'a'] == 0) {
                Set<Character> cur = set.get(sets[c2 - 'a'] - 1);
                cur.add(c1);
                sets[c1 - 'a'] = sets[c2 - 'a'];
                
            } else if (sets[c2 - 'a'] == 0) {
                Set<Character> cur = set.get(sets[c1 - 'a'] - 1);
                cur.add(c2);
                sets[c2 - 'a'] = sets[c1 - 'a'];
            } else if (sets[c1 - 'a'] != sets[c2 - 'a']) {
                Set<Character> f = set.get(sets[c1 - 'a'] - 1);
                Set<Character> s = set.get(sets[c2 - 'a'] - 1);
                for(char c: s) {
                    f.add(c);
                    sets[c - 'a'] = sets[c1 - 'a'];
                }
                s.clear();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            int idx = sets[c - 'a'] - 1;
            if (idx < 0) sb.append(c);
            else sb.append(set.get(idx).iterator().next());
        }
        
        return sb.toString();
    }
}