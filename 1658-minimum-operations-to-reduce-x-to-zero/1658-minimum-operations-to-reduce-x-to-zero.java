class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int el: nums) sum += el;
        
        int maxLen = -1, curSum = 0;
        for(int l = 0, r = 0; r < nums.length; r++) {
            curSum += nums[r];
            while(l <= r && curSum > (sum - x)) curSum -= nums[l++];
            if(curSum == sum -x) maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}