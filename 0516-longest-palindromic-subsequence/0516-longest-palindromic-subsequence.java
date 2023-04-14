class Solution {

    int[][] dp;
    String s;

    public int longestPalindromeSubseq(String s) {
        int len = s.length();        
        dp = new int[len][len];
        this.s = s;
        return f(0, len -1);
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

    // public int longestPalindromeSubseq(String s) {
    //     int len = s.length();        
    //     int[] dp = new int[len];
    //     for (int i = len - 1; i >= 0; i--) {
    //         System.out.println("i is " + i);
    //         int prev = 0; // variable to keep track of dp[j-1] from previous iteration
    //         dp[i] = 1; // initialize dp[i] as 1 since a single character is always a palindrome
    //         for (int j = i + 1; j < len; j++) {
    //             System.out.println("j is " + j);
    //             int temp = dp[j]; // temporarily store dp[j] as it will be updated
    //             System.out.println("temp : " + temp);
    //             System.out.println("prev : " + prev);
    //             if (s.charAt(i) == s.charAt(j)) {
    //                 System.out.println("In if");
    //                 dp[j] = prev + 2; // update dp[j] with dp[j-1] + 2
    //             } else {
    //                 System.out.println("In else");
    //                 dp[j] = Math.max(dp[j], dp[j - 1]); // update dp[j] with max of dp[j] and dp[j-1]
    //             }
    //             System.out.println("dp[j] : " + dp[j]);
    //             prev = temp; // update prev with the previous value of dp[j]
    //         }
    //         System.out.println();
    //     }
    //     return dp[len - 1]; // dp[len - 1] contains the length of the longest palindromic subsequence
    // }
}