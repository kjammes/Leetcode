class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int el: piles)
            high = Math.max(el, high);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f(piles, h, mid))
                high = mid;
            else
                low = mid + 1; 
        }
        return low;
    }
    
    private boolean f(int[] piles, int h, int bananaPerHour) {
        int hrs = 0;
        for (int el: piles) {
            int time = el / bananaPerHour;
            hrs += time;
            if (el % bananaPerHour != 0)
                hrs++;
        }
        return hrs <= h;
    } 
}