class Solution {
    public int numberOfSubarrays(int[] A, int k) {
        int res = 0;
        int count = 0;
        int p = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                k--;
                count = 0;
            }
                
            while (k == 0) {
                k += A[p++] & 1;
                count++;
            }
            res += count;
        }
        
        return res;
    }
}