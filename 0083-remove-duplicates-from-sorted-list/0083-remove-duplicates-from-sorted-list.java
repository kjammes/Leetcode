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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode cur = head;

        while (cur.next != null) {
            ListNode next = cur.next;
            if (next != null && cur.val == next.val) {
                cur.next = next.next;
                next.next = null;
            }

            next = cur.next;
            if (next != null && cur.val != next.val)
                cur = cur.next;
        }
        return head;
    }
}