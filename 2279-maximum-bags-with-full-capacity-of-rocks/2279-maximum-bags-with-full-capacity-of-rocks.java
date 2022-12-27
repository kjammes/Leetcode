class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = rocks.length;
        int res = 0;
        int[] requiredRocks = new int[len];
        for(int i = 0; i < len; i++) {
            requiredRocks[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(requiredRocks);
        for(int i = 0; i < len; i++) {
            if(requiredRocks[i] == 0) {
                res++;
                continue;
            }
            if((additionalRocks - requiredRocks[i]) >= 0) {
                additionalRocks -= requiredRocks[i];
                res++;
            }
        }
        return res;
    }
}