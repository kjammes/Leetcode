class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = getOnes(i);
        }
        return res;
    }
    
    private int getOnes(int num) {
        int res = 0;
        final int MASK = 1;
        for (int i = 0; i < 32; i++) {
            int bit = num & MASK;
            if (bit != 0)
                res++;
            num >>= 1;
        }
        return res;
    }
}