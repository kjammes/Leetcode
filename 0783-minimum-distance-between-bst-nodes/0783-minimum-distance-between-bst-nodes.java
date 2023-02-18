/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        dfs(root, sortedList);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            min = Math.min(min, sortedList.get(i + 1) - sortedList.get(i));
        }
        return min;
    }
    
    private void dfs(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            dfs(node.left, list);
        }
        if (node != null)
            list.add(node.val);
        if (node.right != null)
            dfs(node.right, list);
    }
};