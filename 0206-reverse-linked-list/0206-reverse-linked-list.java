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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        while(head != null) {
             // 2 -> 1 -> null 
            ListNode next = head.next; // 2
            head.next = prev;   // 1-> null
            prev = head;  // 1-> null
            head = next; // 2
        }
        return prev; 
    }
}