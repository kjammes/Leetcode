class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, res, 0);
        return res;
    }

    private void f(int[] nums, List<List<Integer>> res, int idx) {
        if (idx == nums.length) {
            List<Integer> cur = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(cur);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            f(nums, res, idx + 1);
            swap(nums, idx, i);
        }
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}