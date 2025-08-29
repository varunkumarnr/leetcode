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
        Set<ListNode> setA = new HashSet<>(); 
        Set<ListNode> setB = new HashSet<>(); 
        while(headA != null && headB != null) {
            setA.add(headA);
            setB.add(headB);
            if(setA.contains(headB)) return headB; 
            if(setB.contains(headA)) return headA;
            headA= headA.next; 
            headB = headB.next; 
        }
        while(headA != null) {
            if(setB.contains(headA)) return headA; 
            headA = headA.next; 
        }
        while(headB != null) {
            if(setA.contains(headB)) return headB; 
            headB = headB.next; 
        }
        return null;
    }
}