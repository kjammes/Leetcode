class Solution {
    public int maxProfit(int[] prices) {
        // return f(prices, 0, true, new HashMap<>());
        int n = prices.length;
        if (n <= 1) return 0;

        int[] buy = new int[n]; // Maximum profit on day i with a stock in hand
        int[] sell = new int[n]; // Maximum profit on day i with no stock in hand
        buy[0] = -prices[0];
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 1; i < n; i++) {
            // The maximum profit on day i with a stock in hand is either:
            // 1. Continue holding the stock (buy[i-1])
            // 2. Buy the stock on day i (sell[i-2] - prices[i])
            buy[i] = Math.max(buy[i - 1], (i >= 2 ? sell[i - 2] : 0) - prices[i]);

            // The maximum profit on day i with no stock in hand is either:
            // 1. Continue not holding the stock (sell[i-1])
            // 2. Sell the stock on day i (buy[i-1] + prices[i])
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[n - 1];
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
