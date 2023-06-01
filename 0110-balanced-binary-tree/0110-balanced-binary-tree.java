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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lH = getHeight(root.left, 0);
        int rH = getHeight(root.right, 0);
        return (lH == rH || Math.abs(lH - rH) == 1) && isBalanced(root.right) && isBalanced(root.left); 
    }
    
    private int getHeight(TreeNode node, int level) {
        if (node == null)
            return level;
        level++;
        int lH = getHeight(node.left, level);
        int rH = getHeight(node.right, level);
        return Math.max(lH, rH);
    }
}