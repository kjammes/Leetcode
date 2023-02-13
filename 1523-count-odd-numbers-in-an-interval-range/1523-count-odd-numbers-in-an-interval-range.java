class Solution {
    public int countOdds(int low, int high) {
        int len = high - low + 1;
        int res = len/ 2;
        if (len % 2 != 0 && low % 2 != 0)
            res += 1;
        return res;
    }
}