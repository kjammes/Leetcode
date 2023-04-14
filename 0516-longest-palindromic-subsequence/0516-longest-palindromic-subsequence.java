class Solution {

    int[][] dp;
    String s;

    // public int longestPalindromeSubseq(String s) {
    //     int len = s.length();        
    //     // dp = new int[len][len];
    //     // this.s = s;

    //     // return f(0, len -1);

    //     int dp[] = new int[len];
    //     for (int i = len - 1; i >= 0; i--) {
    //         int[] tempDP = new int[len];
    //         dp[i] = 1;
    //         for (int j = i + 1; j < len; j++) {
    //             if (s.charAt(i) == s.charAt(j))
    //                 tempDP[j] = 2 + dp[j - 1];
    //             else
    //                 tempDP[j] = Math.max(dp[j], tempDP[j - 1]);
    //         }
    //         dp = tempDP;
    //     }
    //     return dp[len - 1];
    // }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();        
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int prev = 0; // variable to keep track of dp[j-1] from previous iteration
            dp[i] = 1; // initialize dp[i] as 1 since a single character is always a palindrome
            for (int j = i + 1; j < len; j++) {
                int temp = dp[j]; // temporarily store dp[j] as it will be updated
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev + 2; // update dp[j] with dp[j-1] + 2
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]); // update dp[j] with max of dp[j] and dp[j-1]
                }
                prev = temp; // update prev with the previous value of dp[j]
            }
        }
        return dp[len - 1]; // dp[len - 1] contains the length of the longest palindromic subsequence
    }



    private int f(int l, int r) {
        if (l > r)
            return 0;

        if (dp[l][r] != 0)
            return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            int res = l == r ? 1 : 2;
            dp[l][r] += res + f(l+1, r-1);
        } else {
            dp[l][r] = Math.max(
                f(l+1, r),
                f(l, r-1)
            );
        }

        return dp[l][r];
    }
}