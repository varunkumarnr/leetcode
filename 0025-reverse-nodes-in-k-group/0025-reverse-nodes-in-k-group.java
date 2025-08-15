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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack =  new Stack<>(); 
        Queue<ListNode> queue = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head != null) {
            int n = k; 
            while(head != null && n > 0) {
                stack.add(head); 
                queue.offer(head); 
                head = head.next;
                n--; 
            }
            int size = stack.size(); 
            if(size == k) {
                while(!stack.isEmpty()) {
                    temp.next = stack.pop(); 
                    queue.poll();
                    temp  = temp.next;
                }
            } else {
               while(!queue.isEmpty()) {
                    temp.next = queue.poll(); 
                    stack.pop();
                    temp  = temp.next;
                } 
            }
        }
        temp.next = null;
        return dummy.next; 
    }
}