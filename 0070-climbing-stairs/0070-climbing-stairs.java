class Solution {
    public int climbStairs(int n) {
        int cache[] = new int[n];
        return f(n - 1, cache);
    }
    
    private int f(int n, int[] cache) {
        if (cache[n] != 0)
            return cache[n];
        
        if (n <= 2) {
            cache[n] = n + 1;
            return cache[n];
        }
        
        cache[n] = f(n - 1, cache) + f(n - 2, cache);
        return cache[n];
    }
}