import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sumTotal = 0;

        // Calculate the total sum of elements in the nums array
        for (int i = 0; i < n; i++) {
            sumTotal += nums[i];
        }

        // Calculate the new target value based on the sumTotal and target value
        int newTarget = target + sumTotal;

        // If the new target is odd or negative, it is not possible to achieve the target
        if (newTarget % 2 != 0 || newTarget < 0) {
            return 0;
        }

        // Calculate the updated target value
        newTarget /= 2;

        // Create a 2D DP array for memoization
        int[][] dp = new int[n + 1][newTarget + 1];

        // Initialize the DP array with -1 for all values
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // If the target is greater than the sumTotal, it is not possible to achieve the target
        if (target > sumTotal) {
            return 0;
        }

        // If there is only one element in the array, check if it can achieve the target
        if (n == 1) {
            if (target == nums[0] || target == (-1 * nums[0])) {
                return 1;
            }
            return 0;
        }

        // Call the recursive helper function to calculate the result
        return solve(dp, nums, newTarget, 0);
    }

    private int solve(int[][] dp, int[] nums, int target, int idx) {
        // Base case: If we have reached the end of the array, check if the target sum is achieved.
        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Check if the result for the current state (idx, target) is already computed.
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        // Calculate the number of ways to achieve the target sum by adding '+' and '-' symbols
        // before the current number and recursively explore the next index.
        int take = 0;
        if (target >= nums[idx]) {
            take = solve(dp, nums, target - nums[idx], idx + 1);
        }
        int notTake = solve(dp, nums, target, idx + 1);

        // Store the result in the memoization DP array and return the total number of ways.
        dp[idx][target] = take + notTake;
        return dp[idx][target];
    }
}
