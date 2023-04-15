class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int el: nums) {
            set.add(el);
        }
        
        int res = 0;
        for (int el: nums) {
            if (set.contains(el - 1))
                continue;
            int curSeqLen = 1;
            while (set.contains(el + 1)) {
                curSeqLen++;
                el++;
            }
            res = Math.max(res, curSeqLen);
        }
        
        return res;
    }
}