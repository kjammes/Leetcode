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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursiveHelper(root, 0, res);
        return res;
    }
    
    private void recursiveHelper(TreeNode node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }
        
        if (level == res.size()) {
            res.add(node.val);
        } else {
            res.set(level, node.val);
        }
        
        recursiveHelper(node.left, level + 1, res);
        recursiveHelper(node.right, level + 1, res);
    }
}

