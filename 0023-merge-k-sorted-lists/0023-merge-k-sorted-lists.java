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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a,b) -> a.val - b.val
        );
        for(ListNode v : lists) {
                if(v != null) {
                    minHeap.offer(v);
                }
        }
        while(!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll(); 
            temp.next = curr; 
            temp = temp.next; 
            if(curr.next!= null){
                minHeap.offer(curr.next);
            }
        }
        return dummy.next; 
    }
}