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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        f(root, result);
        
        return result;
    }
    
    private void f(TreeNode node, List<Integer> l) {
        if(node == null)
            return;
        
        l.add(node.val);
        
        if(node.left != null)
        f(node.left, l);
        
        if(node.right != null)
        f(node.right, l);
        
    }
}