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

    Map<Integer, Integer> inorderPositions = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) return null;

        for (int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }

        return builder(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode builder(int[] preorder, int preorderIdx, int inorderStart, int inorderEnd) {
        if (preorderIdx > preorder.length || inorderStart > inorderEnd)
            return null;
        int rootEl = preorder[preorderIdx];
        int idx = inorderPositions.get(rootEl);
        TreeNode root = new TreeNode(rootEl);
        root.left = builder(preorder, preorderIdx + 1, inorderStart, idx - 1);
        root.right = builder(preorder, preorderIdx + (idx - inorderStart) + 1, idx + 1, inorderEnd);
        return root;
    }
    
}