class Solution {
    public int climbStairs(int n) {
        // int cache[] = new int[n];
        // return f(n - 1, cache);
        
        int x = 1;
        int y = 1;
        int z;
        for (int i = 0; i < n - 1; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        return y;
    }
    
//     private int f(int n, int[] cache) {
//         if (cache[n] != 0)
//             return cache[n];
        
//         if (n <= 2) {
//             cache[n] = n + 1;
//             return cache[n];
//         }
        
//         cache[n] = f(n - 1, cache) + f(n - 2, cache);
//         return cache[n];
//     }
}