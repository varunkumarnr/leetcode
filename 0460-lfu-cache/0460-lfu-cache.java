class LFUCache {
    class Node{ 
        int key , value, freq; 
        Node prev, next; 
        Node(int key , int value, int freq) { 
            this.key = key; 
            this.value = value; 
            this.freq = freq; 
        }
    }
    class DoublyLinkedList { 
        Node tail , head; 
        int size;
        DoublyLinkedList(Node head, Node tail) { 
            this.tail = tail; 
            this.head = head; 
            size = 0; 
            tail.prev = head; 
            head.next = tail; 
        }
        void insert(Node node) { 
            node.prev = head; 
            node.next = head.next; 
            head.next.prev = node; 
            head.next = node; 
            size++; 
        }
        void remove(Node  node) { 
            node.prev.next = node.next; 
            node.next.prev = node.prev; 
            size--; 
        }
        int removeTail() { 
            Node curr = tail.prev; 
            tail.prev = curr.prev; 
            curr.prev.next = tail; 
            size--;
            return curr.key;
        }
    }
    final int capacity; 
    Map<Integer, DoublyLinkedList>  bucket;
    Map<Integer, Node> nodeMap; 
    Node head, tail; 
    int least = Integer.MAX_VALUE;
    public LFUCache(int capacity) {
        bucket = new HashMap<>(); 
        nodeMap = new HashMap<>();
        this.capacity   = capacity;
        head = new Node(0, 0,0); 
        tail = new Node(0, 0,0);
    }
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key); 
        DoublyLinkedList dll = bucket.get(node.freq);         
        dll.remove(node);
        if(dll.size == 0 && node.freq == least) {
            least = least +1; // this will be going to least +1 bucket
        }
        node.freq++; 
        if(!bucket.containsKey(node.freq)) { 
            bucket.put(node.freq, new DoublyLinkedList(new Node(0,0,0), new Node(0,0,0))); 
        }
        DoublyLinkedList newdll  = bucket.get(node.freq); 
        newdll.insert(node); 
        return node.value; 
    }
    public void put(int key, int value) {
        if(nodeMap.size() > capacity || (nodeMap.size() >= capacity && !nodeMap.containsKey(key))) { 
            DoublyLinkedList ddl = bucket.get(least); 
            int removedKey = ddl.removeTail(); 
            nodeMap.remove(removedKey); 
            least = Integer.MAX_VALUE; 
        }
        if(!nodeMap.containsKey(key)) { 
            nodeMap.put(key, new Node(key, value, 1)); 
            Node curr = nodeMap.get(key); 
            least = 1; 
            if(!bucket.containsKey(curr.freq)) { 
                bucket.put(curr.freq, new DoublyLinkedList(new Node(0,0,0), new Node(0,0,0)));
            }
            DoublyLinkedList dll= bucket.get(curr.freq); 
            dll.insert(curr); 
        } else {
            Node curr = nodeMap.get(key); 
            DoublyLinkedList ddl = bucket.get(curr.freq); 
            ddl.remove(curr); 
            if(ddl.size == 0 && curr.freq == least) {
                least = least +1;
            }
            curr.freq++; 
            if(!bucket.containsKey(curr.freq)) { 
                bucket.put(curr.freq, new DoublyLinkedList(new Node(0,0,0), new Node(0,0,0))); 
            } 
            DoublyLinkedList newddl = bucket.get(curr.freq);
            curr.value = value;
            newddl.insert(curr); 
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */