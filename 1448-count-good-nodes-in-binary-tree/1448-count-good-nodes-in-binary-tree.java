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
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, 0);
    }
    
    private int helper(TreeNode root, int max, int res) {
        if (root == null)
            return res;
        
        if (root.val >= max) {
            max = root.val;
            res++;
        }
        
        res = helper(root.left, max, res);
        res = helper(root.right, max, res);
        
        return res;
    } 
}
