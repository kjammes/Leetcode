class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        StringBuilder res = new StringBuilder();
        while (p1 < word1.length() && p1 < word2.length()) {
            res.append(word1.charAt(p1));
            res.append(word2.charAt(p1));
            p1++;
        }
        
        while (p1 < word1.length()) { res.append(word1.charAt(p1++)); }
        while (p1 < word2.length()) { res.append(word2.charAt(p1++)); }
        
        return res.toString();
    }
}