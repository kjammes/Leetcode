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
    
    private int getMaxGain(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftMaxGain = Math.max(getMaxGain(root.left), 0);
        int rightMaxGain = Math.max(getMaxGain(root.right), 0);
        
        int curPathSum = root.val + leftMaxGain + rightMaxGain;
        
        maxPath = Math.max(maxPath, curPathSum);
        
        return root.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
