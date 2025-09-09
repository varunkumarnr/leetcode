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
        ListNode prev = null;  // null 
        ListNode curr = head;  // 1 
        while(curr != null) {
            ListNode nxt = curr.next;  // 3  
            curr.next = prev;   // 1 -> null 
            prev = curr;  // 1 -> null
            curr = nxt;  // 2 -> 3 
        }
        return prev;
    }
}