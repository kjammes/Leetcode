class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ( !(str1 + str2).equals(str2 + str1) )
            return "";
        
        int lenOne = str1.length();
        int lenTwo = str2.length();
        int gcd = 1;
        
        int min = Math.min(lenOne, lenTwo);
        for(int i = 2; i <= min; i++) {
            if (lenOne % i == 0 && lenTwo % i == 0)
                gcd = i;
        }
        
        return str1.substring(0, gcd);
    }
}