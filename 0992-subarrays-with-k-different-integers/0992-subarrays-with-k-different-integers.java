class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k -1);
    }
    
    private int atMostK(int[] nums, int k) {
        int res = 0;
        int p = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) == 0)
                k--;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k < 0) {
                map.put(nums[p], map.get(nums[p]) - 1);
                if (map.get(nums[p]) == 0)
                    k++;
                p++;
            }
            res += i - p + 1;
        }
        
        return res;
    }
}