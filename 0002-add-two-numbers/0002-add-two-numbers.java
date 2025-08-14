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
 import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder(); 
        StringBuilder s2 = new StringBuilder();
        
        while(l1!=null) {
            s1.insert(0, l1.val); 
            l1 = l1.next;
        }
        while(l2!=null) {
            s2.insert(0, l2.val);
            l2 = l2.next; 
        }
        // System.out.println(s1.toString() + " " + s2.toString()); 
        String s3 = new BigInteger(s1.toString())
                .add(new BigInteger(s2.toString()))
                .toString();
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy; 
        for(int i = s3.length() -1 ; i >=0; i--) { 
            temp.next = new ListNode(s3.charAt(i) - '0'); 
            temp = temp.next; 
        }
        return dummy.next; 
     }
}