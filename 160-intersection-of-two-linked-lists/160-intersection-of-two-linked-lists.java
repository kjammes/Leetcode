/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        int diff = 0;
        if(lenA > lenB) {
            diff = lenA - lenB;
            while(diff-- != 0) {
                tempA = tempA.next;
            }
        } else if(lenB > lenA) {
            diff = lenB - lenA;
            while(diff-- != 0) {
                tempB = tempB.next;
            }
        }
        
        while(tempA != null || tempB != null) {
            if(tempA == tempB)
                return tempA;
            
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return null;
    }
    
    private int getLength(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}