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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymHelper(root.left, root.right);
    }
    
    private boolean isSymHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        
        if (left == null || right == null || left.val != right.val)
            return false;
        
        return isSymHelper(left.left, right.right) && isSymHelper(right.left, left.right);
    }
}