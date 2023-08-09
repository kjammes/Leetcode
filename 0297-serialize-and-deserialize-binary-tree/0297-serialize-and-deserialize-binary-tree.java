/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        srDFS(root, list);
        return String.join(",", list);
    }
    
    private void srDFS(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(node.val));
        srDFS(node.left, list);
        srDFS(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dsDFS(data.split(","));
    }
    
    private TreeNode dsDFS(String[] data) {
        String el = data[idx];
        if (el.equals("N")) {
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(el));
        idx++;
        node.left = dsDFS(data);
        node.right = dsDFS(data);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));