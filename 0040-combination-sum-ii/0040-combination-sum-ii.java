class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        f(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }
    
    private void f(int[] candidate, int target, List<Integer> cur, List<List<Integer>> res, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0)
            return;
        for (int i = idx; i < candidate.length; i++) {
            if (i > idx && candidate[i] == candidate[i-1])
                continue;
            cur.add(candidate[i]);
            f(candidate, target - candidate[i], cur, res, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}