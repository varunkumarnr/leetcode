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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head; 
        ListNode fast = head;
        int steps= 0; 
        while(fast != null && fast.next != null) {
            steps++; 
            fast = fast.next.next; 
        }
        int required = 0;
        if(fast == null) {
            required = (2*steps) - (n); 
        } else {
            required = ((2*steps) +1) - (n); 
        }
        while(required > 0) {
            slow = slow.next; 
            required--; 
        }
        ListNode dummy = new ListNode(0); 
        ListNode temp = dummy; 
        while(head!=null) {
            if(head == slow) {
                if(slow != null) {
                    temp.next = slow.next;
                }
                return dummy.next; 
            }
            temp.next = head; 
            temp = temp.next;
            head = head.next;
        }
         return dummy.next; 
    }
}