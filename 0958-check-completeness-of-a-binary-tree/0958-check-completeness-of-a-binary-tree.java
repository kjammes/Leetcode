class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));
        while (q.peek() != null) {
            
            TreeNode node = q.poll();
            q.add(node.left);
            q.add(node.right);
        }
        
        while (!q.isEmpty() && q.peek() == null)
            q.poll();
        
        return q.isEmpty();
    }
}