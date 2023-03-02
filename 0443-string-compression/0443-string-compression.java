class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        if (len == 1)
            return 1;
        
        int res = 0;
        for (int i = 0; i < len;) {
            int count = 1;
            char c = chars[i];
            while (i + 1 < len && chars[i] == chars[i+1] ) {
                count++;
                i++;
            }
            
            chars[res++] = c;
            if (count > 1) {
                String counterString = count + "";
                for(int r = 0; r < counterString.length(); r++){
                    chars[res++] = counterString.charAt(r);
                }
            }
            
            i++;
        }
        return res;
    }
}