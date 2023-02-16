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
    int result = 0;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return result;
        else
            result = 1;
        dfs(root, 1);
        return result;
    }
    
    private void dfs(TreeNode node, int level) {
        int nextLevel = ++level;
        if (node.left != null) {
            result = Math.max(result, nextLevel);
            dfs(node.left, nextLevel);
        }
        if (node.right != null) {
            result = Math.max(result, nextLevel);
            dfs(node.right, nextLevel);
        }
    }
}