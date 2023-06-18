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
    
    int counter = 0;
    int res = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        inorder(root);
        return res;
    }
    
    private void inorder(TreeNode node) { 
        if (node.left != null) { inorder(node.left); }
        counter--; 
        if (counter == 0) { res = node.val; return; }
        if (node.right != null) inorder(node.right);
    }
}