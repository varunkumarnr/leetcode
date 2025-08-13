class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find length and connect tail to head (circular list)
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head; // circle

        // Find new head after rotation
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // break circle

        return newHead;
    }
}
