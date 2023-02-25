class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1)
            return 0;
        
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int price: prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}