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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int level) {
        if (root == null)
            return level;
        level += 1;
        int maxLeft = maxDepth(root.left, level);
        int maxRight = maxDepth(root.right, level);
        return Math.max(maxLeft, maxRight);
    }
}