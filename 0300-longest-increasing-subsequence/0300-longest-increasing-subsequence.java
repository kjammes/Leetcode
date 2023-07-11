class Solution {
    public int lengthOfLIS(int[] nums) {
        // int len = nums.length;
        // if (len == 1)
        //     return 1;
        // int dp[] = new int[len];
        // Arrays.fill(dp, 1);
        // int res = 1;
        // for (int start = len - 1; start >= 0; start--) {
        //     for (int idx = start + 1; idx < len; idx++) {
        //         if (nums[idx] > nums[start])
        //             dp[start] = Math.max(dp[start], 1 + dp[idx]);
        //     }
        //     res = Math.max(res, dp[start]);
        // }
        // return res;
        List<Integer> tails = new ArrayList<>(); // ArrayList to store tails of increasing subsequences

        for (int num : nums) {
            if (tails.isEmpty() || num > tails.get(tails.size() - 1)) {
                // If num is greater than the last element of tails, append num to tails
                tails.add(num);
            } else {
                // Perform binary search to find the smallest element in tails greater than or equal to num
                int left = 0;
                int right = tails.size() - 1;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                // Update the tail element found with num
                tails.set(left, num);
            }
        }

        return tails.size();
    }
}