class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (row1, row2) -> row2[0] - row1[0]);
        Stack<Integer> dups = new Stack<>();
        Set<Integer> curKEls = new HashSet<>();
        long totalProfit = 0, maxElegence = 0;
        for (int i = 0; i < items.length; i++) {
            int profitI = items[i][0], categoryI = items[i][1];
            if (i < k) {
                totalProfit += profitI;
                if (curKEls.contains(categoryI)) {
                    dups.push(profitI);
                }
            } else if (!curKEls.contains(categoryI)) {
                if (dups.empty())
                    break;
                totalProfit += -dups.pop() + profitI;
            }
            curKEls.add(categoryI);
            maxElegence = Math.max(maxElegence, totalProfit + 1L * curKEls.size() * curKEls.size());
        }
        
        return maxElegence;
    }
}