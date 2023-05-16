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
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode cur = head;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
            prev = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}