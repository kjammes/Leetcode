class Solution {
    public String mergeAlternately(String word1, String word2) {
        int idx = 0;
        StringBuilder res = new StringBuilder();
        while (idx < word1.length() && idx < word2.length()) {
            res.append(word1.charAt(idx));
            res.append(word2.charAt(idx));
            idx++;
        }
        
        while (idx < word1.length()) { res.append(word1.charAt(idx++)); }
        while (idx < word2.length()) { res.append(word2.charAt(idx++)); }
        
        return res.toString();
    }
}