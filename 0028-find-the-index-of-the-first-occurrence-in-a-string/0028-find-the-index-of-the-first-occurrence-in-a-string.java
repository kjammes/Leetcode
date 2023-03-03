class Solution {
    public int strStr(String haystack, String needle) {
        int lenH = haystack.length();
        int lenN = needle.length();
        
        if (lenN > lenH)
            return -1;
        
        if (lenN == lenH)
            return needle.equals(haystack) ? 0 : -1;
        
        char needleStart = needle.charAt(0);
        for(int i = 0; i < lenH; i++) {
            if (haystack.charAt(i) == needleStart && needleStart(i, haystack, needle))
                return i;
        }
        
        return -1;
    }
    
    private boolean needleStart(int i, String haystack, String needle) {
        if (i + needle.length() > haystack.length())
            return false;
        
        for (int idx = 0; idx < needle.length(); idx++) {
            if (haystack.charAt(i + idx) != needle.charAt(idx))
                return false;
        }
        return true;
    }
}