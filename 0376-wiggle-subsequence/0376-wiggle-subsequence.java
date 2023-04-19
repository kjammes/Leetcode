class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;

        if (len == 0 || len == 1)
            return len;

        if (len == 2 && nums[1] == nums[0])
            return 1;

        
        int dp = 1;

        char prev = '_';
        for (int i = 1; i < len; i++) {

            char curDiffSign = nums[i] - nums[i-1] > 0 ? 'P' : 'N';
            if (prev == curDiffSign || nums[i] == nums[i-1])
                continue;
            
            dp++;
            prev = curDiffSign;
        }

        return dp;
    }
}