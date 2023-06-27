class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(candidates, target, new ArrayList<>(), 0, 0, res);
        return res;
    }

    private void f(int[] candidates, int target, List<Integer> cur, int idx, int sum, List<List<Integer>> res) {
        if (sum > target) return;

        if (sum == target) {
            res.add(new ArrayList(cur));
            return;
        }

        if (idx >= candidates.length) return;

        cur.add(candidates[idx]);
        f(candidates, target, cur, idx, sum + candidates[idx], res);
        cur.remove(cur.size() - 1);
        f(candidates, target, cur, idx + 1, sum, res);
    }
}