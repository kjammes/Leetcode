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
    
    public int kthSmallest(TreeNode root, int k) {
       int[] counter = new int[]{k};
        return inorder(root, counter);
    }
    
    private int inorder(TreeNode node, int[] counter) { 
        if (node == null) {
            return -1; // or any value that indicates not found
        }
        
        int leftResult = inorder(node.left, counter);
        
        if (leftResult != -1) {
            return leftResult;
        }
        
        counter[0]--;
        if (counter[0] == 0) {
            return node.val;
        }
        
        return inorder(node.right, counter);
    }
}