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
        if (root == null) {
            return 0;
        }
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        nodeStack.push(root);
        maxStack.push(root.val);
        
        int count = 0;
        
        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            int maxVal = maxStack.pop();
            
            if (node.val >= maxVal) {
                count++;
                maxVal = node.val;
            }
            
           
            if (node.left != null) {
                nodeStack.push(node.left);
                maxStack.push(maxVal);
            }
            
            if (node.right != null) {
                nodeStack.push(node.right);
                maxStack.push(maxVal);
            }
        }
        
        return count;
    }
}

