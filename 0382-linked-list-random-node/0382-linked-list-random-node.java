/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode head = null;
    Random random = null;
    
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    public int getRandom() {
        int res = 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            res = random.nextInt(count) == 0 ? cur.val : res;
            cur = cur.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */