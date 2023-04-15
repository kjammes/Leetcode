class Solution {
    int dp[][];

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int len = piles.size();
        dp = new int[len + 1][k + 1];
        return f(piles, k, 0);
    }

    private int f(List<List<Integer>> piles, int k, int pileNo) {
        if (dp[pileNo][k] > 0)
            return dp[pileNo][k];

        if (k == 0 || pileNo == piles.size())
            return 0;

        int res = f(piles, k, pileNo + 1);

        int minRange = Math.min(piles.get(pileNo).size(), k);
        int curPile = 0;
        for (int i = 0; i < minRange; i++) {
            curPile += piles.get(pileNo).get(i);
            res =  Math.max(
                res,
                curPile + f(piles, k - i - 1, pileNo + 1)
            );
        }

        dp[pileNo][k] = res;
        return res;
    }
}