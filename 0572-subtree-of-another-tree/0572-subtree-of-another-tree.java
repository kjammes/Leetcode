class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        TreeNode subRootInRoot = getMatching(root, subRoot);
        if (subRootInRoot == null)
            return false;
        return isSameTree(subRootInRoot, subRoot);
    }

    private TreeNode getMatching(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return null;
        if (isSameTree(root, subRoot))
            return root;
        TreeNode found = getMatching(root.left, subRoot);
        if (found == null) {
            found = getMatching(root.right, subRoot);
        }
        return found;
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
