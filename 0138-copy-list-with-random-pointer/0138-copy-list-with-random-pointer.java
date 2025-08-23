/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new LinkedHashMap<>(); 
        Node curr = head;
        while(curr!= null) {
            map.put(curr, new Node(curr.val)); 
            curr = curr.next; 
        }
        Node dummy = new Node(0); 
        Node temp = dummy; 
        for(Map.Entry<Node,Node> entry: map.entrySet()) { 
            Node key = entry.getKey();
            Node value = entry.getValue(); 
            value.next = map.get(key.next); 
            value.random = map.get(key.random); 
            temp.next  = value; 
            temp = temp.next; 
        }
        return dummy.next;
    }
}