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
    
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return res;
        
        dfs(root, 0);
        
        return res;
    }
    
    private void dfs(TreeNode node, int cur) {
        if (node == null)
            return;
        
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            
            res += cur;
            return;
        }
        dfs(node.left, cur);
        dfs(node.right, cur);
        cur /= 10;
    }
}