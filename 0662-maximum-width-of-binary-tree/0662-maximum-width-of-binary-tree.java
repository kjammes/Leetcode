class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;

        if (root == null)
            return res;

        Queue<DNode> q = new LinkedList<>();
        DNode n = new DNode(root, 0, 1);
        DNode startLevelNode = n;
        int prevLevel = 0;
        q.add(n);
        while (!q.isEmpty()) {
            DNode cur = q.remove();
            if (cur.level > prevLevel) {
                prevLevel = cur.level;
                startLevelNode = cur;
            }
            res = Math.max(res, cur.calVal - startLevelNode.calVal + 1);
            if (cur.node.left != null)
                q.add(new DNode(cur.node.left, cur.level + 1, cur.calVal * 2));
            if (cur.node.right != null)
                q.add(new DNode(cur.node.right, cur.level + 1, cur.calVal * 2  + 1));
        }
        
        return res;
    }
}

class DNode {
    TreeNode node;
    int level;
    int calVal;

    DNode(TreeNode node, int level, int calVal) {
        this.node = node;
        this.level = level;
        this.calVal = calVal;
    }
}
