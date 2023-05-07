class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int[] res = new int[nums.length];
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < nums.length; i++) {
            // if (i == nums.length - 1) 
                // System.out.println(Arrays.toString(dp));
            int n = nums[i];
            int index = bs(dp, i + 1, n);
            res[i] = index + 1;
            dp[index] = n;
        }

        return res;
    }

    private int bs(int[] arr, int len, int target) {
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
