class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int el: nums) {
            if (visited.contains(el))
                return true;
            visited.add(el);
        }
        return false;
    }
}