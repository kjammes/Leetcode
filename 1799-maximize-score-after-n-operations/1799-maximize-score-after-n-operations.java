class Solution {

    private int f(int[] nums, int mask, int op, int[] dp, int[][] gcd) {
        int len = nums.length;

        int n = len / 2; // Number of operations to be performed

        if (op > n) return 0;

        if (dp[mask] != -1) return dp[mask];

        for (int i = 0; i < len; i++) {
            if ( (mask & (1 << i)) != 0) continue;
            for (int j = i + 1; j < len; j++) {
                if ( (mask & (1 << j)) != 0) continue;
                int newMask =  (1 << i) | (1 << j) | mask;
                int score = op * gcd[i][j] + f(nums, newMask, op + 1, dp, gcd);
                dp[mask] = Math.max(dp[mask], score);
            }
        }

        return dp[mask];
    }

    public int maxScore(int[] nums) {
        int dp[] = new int[1<<14]; // Same as 2 ** 14
        Arrays.fill(dp, -1);
        
        int len = nums.length;
        int gcd[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                gcd[i][j] = gcd(nums[i], nums[j]);
            }
        }

        return f(nums, 0, 1, dp, gcd);
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }
}
