class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        
        int jumps = 0;
        int cur   = 0;
        int max   = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == cur) {
                cur = max;
                jumps++;
            }
            
            if (cur > nums.length - 1)
                return jumps;
        }
        return jumps;
    }
}