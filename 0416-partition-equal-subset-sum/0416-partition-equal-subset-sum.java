class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        // If the total sum is odd, it cannot be divided equally
        if (totalSum % 2 != 0)
            return false;

        int targetSum = totalSum / 2;
        Map<String, Boolean> memo = new HashMap<>();
        return canPartitionUtil(nums, targetSum, 0, 0, 0, memo);
    }

    private boolean canPartitionUtil(int[] nums, int targetSum, int currSum1, int currSum2, int idx, Map<String, Boolean> memo) {
        if (currSum1 == targetSum || currSum2 == targetSum)
            return true;

        if (currSum1 > targetSum || currSum2 > targetSum)
            return false;

        String key = currSum1 + "-" + currSum2;
        if (memo.containsKey(key))
            return memo.get(key);

        boolean foundPartition = canPartitionUtil(nums, targetSum, currSum1 + nums[idx], currSum2, idx + 1, memo) ||
                                 canPartitionUtil(nums, targetSum, currSum1, currSum2 + nums[idx], idx + 1, memo);

        memo.put(key, foundPartition);
        return foundPartition;
    }
}
