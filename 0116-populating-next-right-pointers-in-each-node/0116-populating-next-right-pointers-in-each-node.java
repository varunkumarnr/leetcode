/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); 
        while(!queue.isEmpty()) {
            int n = queue.size(); 
            while(n > 0) {
                Node curr = queue.poll(); 
                if (n > 1) curr.next = queue.peek();
                else curr.next = null; 
                n--; 
                if(curr.left != null) queue.offer(curr.left); 
                if(curr.right!= null) queue.offer(curr.right); 
            }
        }
        return root; 
    }
}