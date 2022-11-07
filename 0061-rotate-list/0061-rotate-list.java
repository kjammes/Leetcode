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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int len = getLength(head);
        k = k % len;
        
        if(k == 0)
            return head;
        
        ListNode curNode = head;
        int limit = len - k - 1;
        while(limit-- > 0) {
            curNode = curNode.next;
        }
        
        ListNode newHead = curNode.next;
        curNode.next = null;
        
        curNode = newHead;
        while(curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = head;
        
        return newHead;
        
    }
    
    private int getLength(ListNode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}