class Solution {
    public String longestCommonPrefix(String[] strs) {    
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            
            boolean allSame = true;
            for(int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if ((s.length() - 1 < i) || s.charAt(i) != ch ) {
                    allSame = false;
                    return res.toString();
                }
            }
            
            if(allSame) {
                res.append(ch);
            }
        }
        
        return res.toString();
    }
}