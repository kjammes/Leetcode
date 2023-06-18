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
    int res;
    public int goodNodes(TreeNode root) {
        res = 0;
        helper(root, Integer.MIN_VALUE);
        return res;
    }
    
    private void helper(TreeNode root, int max) {
        if (root == null)
            return;
        if (root.val >= max) {
            max = root.val;
            res++;
        } 
        helper(root.left, max);
        helper(root.right, max);
    } 
}