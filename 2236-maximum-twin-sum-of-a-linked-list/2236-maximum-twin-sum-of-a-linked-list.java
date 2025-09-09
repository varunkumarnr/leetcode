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
    public int pairSum(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        if(head.next == null) {
            return head.val; 
        }
        while(fast != null && fast.next!=null) {
            slow = slow.next; 
            fast = fast.next.next;
        }
        // when it reachs end slow would be mid. 
        int result = Integer.MIN_VALUE; 
        ListNode prev = null; 
        ListNode curr = slow;
        while(curr != null) {
            ListNode nxt = curr.next; 
            curr.next = prev;
            prev = curr; 
            curr = nxt;  
        }
        while(head != null && prev != null) { 
            result = Math.max(result , head.val + prev.val); 
            head = head.next; 
            prev = prev.next; 
        }
        return result; 
    }
}