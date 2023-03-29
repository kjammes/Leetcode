class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int preSum = 0, res = 0;
        int len = satisfaction.length;
        
        for (int i = len - 1; i >= 0; i--) {
            preSum += satisfaction[i];
            if (preSum < 0)
                break;
            res = res + preSum;
        }
        return res;
    }
}