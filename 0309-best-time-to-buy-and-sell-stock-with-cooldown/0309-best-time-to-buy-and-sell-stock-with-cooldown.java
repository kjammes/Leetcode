class Solution {
    public int maxProfit(int[] prices) {
        return f(prices, 0, true, new HashMap<>());
    }
    
    private int f(int[] prices, int idx, boolean canBuy, Map<String, Integer> cache) {
        if (idx >= prices.length)
            return 0;
        
        String key = idx + "-" + canBuy;
        if (cache.containsKey(key))
            return cache.get(key);
            
        int skip = f(prices, idx + 1, canBuy, cache);
        int res = Integer.MIN_VALUE;
        if (canBuy) {
            int buy = f(prices, idx + 1, false, cache) - prices[idx];
            res = Math.max(buy, skip);
        } else {
            int sell = f(prices, idx + 2, true, cache) + prices[idx];
            res = Math.max(sell, skip);
        }
        
        cache.put(key, res);
        return cache.get(key);
    }
}
