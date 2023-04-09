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
            
        ListNode dummy = new ListNode(-101);
        ListNode cur = dummy;

        while (head !=null) {
            boolean repeat = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                repeat = true;
            }

            if (!repeat) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }        
            head = head.next;
        }
        return dummy.next;
    }
}