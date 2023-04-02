class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int res[] = new int[spells.length];
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        for (int idx = 0; idx < n; idx++) {
            int startIdx = bs(spells[idx], potions, success);
            res[idx] = m - startIdx;
        }

        return res;
    }

    private int bs(int sPower, int[] potions, long success) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = ( left + ( right - left ) / 2 );
            long product = (long) (1l * sPower) * potions[mid];

            if (product < success) 
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}