public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        final int MASK = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & MASK) == 1)
                res++;
            n >>= 1;
        }
        return res;
    }
}