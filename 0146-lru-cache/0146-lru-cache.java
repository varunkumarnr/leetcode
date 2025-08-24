// class LRUCache {
//     Map<Integer, Integer> map;
//     int limit = 0; 
//     public LRUCache(int capacity) {
//         map = new LinkedHashMap<>(capacity, 1.00f, true);
//         limit = capacity; 
//     }
//     public int get(int key) {
//         if(map.containsKey(key)) {
//             return map.get(key);
//         } else {
//             return -1;
//         }
//     }
    
//     public void put(int key, int value) {
//         if(map.containsKey(key)) {
//             map.put(key, value);
//         } else {
//         if(map.size() < limit) {
//             map.put(key, value);
//         } else {
//             for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                 int keys = entry.getKey();
//                 map.remove(keys);
//                 break;
//             }
//             map.put(key, value);
//         }
//         }
//     }
// }

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */


class LRUCache {
    class Node{
        int key,  val; 
        Node prev, next; 
        Node(int key, int val) {
            this.key = key; 
            this.val = val;
        }
    }
    private final int capacity; 
    private Map<Integer, Node> map; 
    private Node head, tail; 
    public LRUCache(int capacity) { 
        this.capacity = capacity; 
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0, 0); 
        head.next = tail; 
        tail.prev = head;  
    }
    public int get(int key) {
    if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.val;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
            Node lru = tail.prev; 
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key, newNode);
        }

    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertToHead(Node node) {
        node.next = head.next; 
        head.next.prev = node; 
        head.next = node; 
        node.prev = head; 
    }
}