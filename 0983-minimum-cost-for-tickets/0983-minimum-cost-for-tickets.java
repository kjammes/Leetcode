class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = new HashSet<>();
        for (int el: days)
            daysSet.add(el);

        int dp[] = new int[366];
        for (int i = 1; i <= 365; i++) {
            if (!daysSet.contains(i))
                dp[i] = dp[Math.max((i - 1), 0)];
            else {
                int dayCharge = dp[Math.max((i - 1), 0)] + costs[0];
                int weekCharge = dp[Math.max((i - 7), 0)] + costs[1];
                int yearCharge = dp[Math.max((i - 30), 0)] + costs[2];

                dp[i] = Math.min(dayCharge, Math.min(weekCharge, yearCharge));
            }
        }

        return dp[365];
    }
}