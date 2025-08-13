class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int length = stack.size();
        k = k % length;
        if (k == 0) return head;

        for (int i = 0; i < k; i++) {
            curr = stack.pop();
        }

        ListNode newHead = curr;
        ListNode prevTail = stack.peek();
        prevTail.next = null;

        ListNode temp = newHead;
        while (temp.next != null) temp = temp.next;
        temp.next = head;

        return newHead;
    }
}
