/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if(root == null)
            return result;
        
        f(root, result);
        
        
        return result;
    }
    
    private List<Integer> f(Node node, List<Integer> l) {
        if(node == null) return l;
        
        for(Node n : node.children)
            f(n, l);
        
        l.add(node.val);
        
        return l;
    }
}