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
    int maxPath = Integer.MIN_VALUE; // placeholder to be updated
    
    public int maxPathSum(TreeNode root) {
        getMaxGain(root); // Starts the recursion chain
        return maxPath;
    }
    
    private int getMaxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int gainOnLeft = Math.max(getMaxGain(node.left), 0); // Read the part important observations
        int gainOnRight = Math.max(getMaxGain(node.right), 0); // Read the part important observations
        
        int currentMaxPath = node.val + gainOnLeft + gainOnRight; // Read first three images of going down the recursion stack
        maxPath = Math.max(maxPath, currentMaxPath); // Read first three images of going down the recursion stack
        
        return node.val + Math.max(gainOnLeft, gainOnRight); // Read the last image of going down the recursion stack
    }
}
