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
    Map<Integer, Integer> inorderMap;
    List<Integer> postorderList;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postorderList = new ArrayList<>();
        for (int el: postorder)
            postorderList.add(el);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int l, int r) {
        if (l > r)
            return null;

        TreeNode root = new TreeNode(postorderList.remove(postorderList.size() - 1));
        int idx = inorderMap.get(root.val);
        root.right = helper(idx + 1, r);
        root.left = helper(l, idx - 1);

        return root;
    }

}