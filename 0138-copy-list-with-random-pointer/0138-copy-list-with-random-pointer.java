/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) 
            return null;

        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);

        Node cur = copyHead;

        while (head != null) {
            if (head.random == null) {
                cur.random = null;
            } else if (map.containsKey(head.random)) {
                cur.random = map.get(head.random);
            } else {
                Node random = new Node(head.random.val);
                cur.random = random;
                map.put(head.random, random);
            }

            if (head.next == null) {
                break;
            }

            head = head.next;
            if (map.containsKey(head)) {
                cur.next = map.get(head);
            } else {
                Node next = new Node(head.val);
                cur.next = next;
                map.put(head, next);
            }
            cur = cur.next;
        }

        return copyHead;
    }

}