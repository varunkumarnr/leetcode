/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node clone = new Node();
        if(node == null) return node; 
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        queue.add(node);   
        map.put(node, new Node(node.val)); 
        while(!queue.isEmpty()) {
            Node curr = queue.poll(); 
            for(Node neighbor: curr.neighbors) {
                if(!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }     
        }
        return map.get(node); 
    }
}