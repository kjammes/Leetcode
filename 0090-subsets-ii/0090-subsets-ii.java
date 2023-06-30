class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        f(nums, new ArrayList<>(), res, 0);
        return res;
    }
    
    private void f(int[] nums, List<Integer> cur, List<List<Integer>> res, int idx) {
        res.add(new ArrayList<>(cur));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1])
                continue;
            cur.add(nums[i]);
            f(nums, cur, res, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}