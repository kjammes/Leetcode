class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 1;
        int res = 1;
        String prev = "";
        while (r < arr.length) {
            if ((arr[r - 1] > arr[r]) && !prev.equals(">")) {
                prev = ">";
                res = Math.max(res, r - l + 1);
                r++;
            } else if ((arr[r - 1] < arr[r]) && !prev.equals("<")) {
                prev = "<";
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                r += arr[r] == arr[r-1] ? 1 : 0;
                l = r - 1;
                prev = "";
            }
        }
        
        return res;
    }
}