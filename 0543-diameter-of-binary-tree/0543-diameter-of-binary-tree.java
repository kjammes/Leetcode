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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int lH = findH(root.left, 0);
        int rH = findH(root.right, 0);
        
        res = Math.max(res, lH + rH);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return res;
    }
    
    private int findH(TreeNode node, int level) {
        if (node == null)
            return level;
        level++;
        int lH = findH(node.left, level);
        int rH = findH(node.right, level);
        
        return Math.max(lH, rH);
    }
}