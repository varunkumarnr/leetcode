class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode temp = head; 
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++; 
        }
        ListNode trev = head;
        Queue<ListNode> stack = new LinkedList<>();
        ListNode ending = new ListNode(0);
        ListNode point = ending; 
        int rev = size > k ? size - k : size - (k % size);  
            while(rev > 0) {
                ending.next = trev;
                ending = ending.next;
                trev = trev.next;  
                rev--; 
            }   
            ending.next = null; 
            while(trev != null) {
                stack.offer(trev);    
                trev = trev.next; 
            }
        ListNode remaining = point.next; 
        ListNode dummy = new ListNode(0);
        ListNode temp1 = dummy;
        while(!stack.isEmpty()) {
            ListNode curr = stack.poll(); 
            temp1.next = curr; 
            temp1 = temp1.next; 
        }      
        while(remaining != null) {
            temp1.next = remaining; 
            temp1 = temp1.next;
            remaining  = remaining.next;
        }
        return dummy.next; 
    }
}
