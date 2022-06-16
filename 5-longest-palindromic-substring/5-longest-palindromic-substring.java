class Solution {
    public String expand(String s,int l,int r){
        while( l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
    public String longestPalindrome(String s) {
        String temp="";
        if(s.length()<=1)
            return s;
        for(int i=0;i<s.length();i++){
            String even=expand(s,i,i+1);
            String odd=expand(s,i,i);
            if(odd.length()>temp.length())
                temp=odd;
            if(even.length()>temp.length())
                temp=even;
        }
        return temp;
    }
}