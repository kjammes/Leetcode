class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int w: weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;
        
        while (l <= r) {
            int cap = r - ((r - l) / 2);
            if (canShip(cap, days, weights)) {
                res = Math.min(cap, res);
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }
        
        return res;
    }
    
    private boolean canShip(int cap, int days, int[] weights) {
        int ships = 1;
        int curCap = cap;
        for (int w: weights) {
            if (curCap - w < 0) {
                ships++;
                curCap = cap;
            }
            curCap -= w;
        }
        return ships <= days;
    }
}