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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        
        List<List<String>> resList = new ArrayList<>();
        f(root, resList, new ArrayList<String>());
        
        return resList.stream()
            .map(el -> String.join("->", el))
            .collect(Collectors.toList());
    }
    
    private void f(TreeNode node, List<List<String>> resList, List<String> curList) {
        if(node == null) return;
        curList.add(String.valueOf(node.val));
        
        if(node.left == null && node.right == null) 
            resList.add(new ArrayList(curList));

        f(node.left, resList, curList);
        f(node.right, resList, curList);
        
        curList.remove(curList.size() - 1);
    }
}