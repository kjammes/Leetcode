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
    private int maxLen = 0;
    
    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        f(root, 'L', 0);
        f(root, 'R', 0);
        return maxLen;
    }

    private void f(TreeNode node, char prevDir, int curLen) {
        if (node == null)
            return;
            
        maxLen = Math.max(maxLen, curLen);
        
        f(node.right, 'R', prevDir == 'R' ? 1 : curLen + 1);
        f(node.left, 'L', prevDir == 'L' ? 1 : curLen + 1);
    }
}