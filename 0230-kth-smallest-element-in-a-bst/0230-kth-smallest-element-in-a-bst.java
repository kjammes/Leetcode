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
        List<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k-1);
    }
    
    private void inorder(TreeNode node, List<Integer> list, int k) {
        if (node == null)
            return;
        if (list.size() == k) {
            return;
        }   
        inorder(node.left, list, k);
        list.add(node.val);
        inorder(node.right, list, k);
    }
}