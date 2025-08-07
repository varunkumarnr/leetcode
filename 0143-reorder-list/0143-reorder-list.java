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
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next; 
        }
        Stack<ListNode> stack = new Stack<>(); 
        ListNode curr = slow.next; 
        slow.next = null;
        while(curr != null) {
                stack.push(curr);
                curr = curr.next; 
        }
         ListNode first = head;

        while (!stack.isEmpty()) {
            ListNode top = stack.pop();

            top.next = first.next;
            first.next = top;
            first = top.next;
        }
    }
}