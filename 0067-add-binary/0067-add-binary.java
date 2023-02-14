class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        
        int carry = 0;
        while (aPointer > -1 || bPointer > -1) {
            int sum = carry;
            if (aPointer > -1) 
                sum += a.charAt(aPointer--) - '0';
            if (bPointer > -1)
                sum += b.charAt(bPointer--) - '0';
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
        }
        
        if (carry == 1)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}