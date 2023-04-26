class Solution {
    public int addDigits(int num) {
        if (num < 10)
            return num;
        
        while (num >= 10) {
            int tmp = num;
            int intermediateRes = 0;
            while (tmp != 0) {
                intermediateRes += tmp % 10;
                tmp /= 10;
            }
            num = intermediateRes;
        }
        
        return num;
    }
}