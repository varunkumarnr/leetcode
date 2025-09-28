class AllOne {
    class Node { 
        String key;
        int freq; 
        Node prev, next; 
        Node(String key, int freq) {
            this.key = key; 
            this.freq = freq; 
        }
    }

    class DoublyLinkedList { 
        Node head, tail; 
        int size; 
        DoublyLinkedList() { 
            head = new Node("", 0);
            tail = new Node("", 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void insert(Node node) { 
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++; 
        }

        void remove(Node node) { 
            node.prev.next = node.next;
            node.next.prev = node.prev; 
            size--; 
        }

        String getKey() { 
            return head.next.key; 
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    HashMap<String, Node> nodeMap; 
    HashMap<Integer, DoublyLinkedList> bucket; 
    int least, max; 

    public AllOne() {
        nodeMap = new HashMap<>();
        bucket = new HashMap<>();
        least = 0;
        max = 0;
    }

    public void inc(String key) {
        if(!nodeMap.containsKey(key)) { 
            Node curr = new Node(key, 1);
            nodeMap.put(key, curr);
            least = 1;
            max = Math.max(max, 1);

            bucket.putIfAbsent(1, new DoublyLinkedList());
            bucket.get(1).insert(curr);
        } else {
            Node curr = nodeMap.get(key);
            int oldFreq = curr.freq;
            DoublyLinkedList oldList = bucket.get(oldFreq);
            oldList.remove(curr);

            curr.freq++;
            bucket.putIfAbsent(curr.freq, new DoublyLinkedList());
            bucket.get(curr.freq).insert(curr);

            if(oldList.isEmpty() && oldFreq == least) {
                least = curr.freq; 
            }
            max = Math.max(max, curr.freq);
        }
    }

    public void dec(String key) {
        Node curr = nodeMap.get(key);
        int oldFreq = curr.freq;
        DoublyLinkedList oldList = bucket.get(oldFreq);
        oldList.remove(curr);

        if(curr.freq == 1) {
            nodeMap.remove(key);
        } else {
            curr.freq--;
            bucket.putIfAbsent(curr.freq, new DoublyLinkedList());
            bucket.get(curr.freq).insert(curr);
        }

        if(!nodeMap.isEmpty()) {
            least = bucket.keySet().stream().filter(f -> bucket.get(f).size > 0).min(Integer::compare).get();
            max   = bucket.keySet().stream().filter(f -> bucket.get(f).size > 0).max(Integer::compare).get();
        } else {
            least = 0;
            max = 0;
        }
    }

    public String getMaxKey() {
        if(nodeMap.isEmpty()) return "";
        return bucket.get(max).getKey();
    }

    public String getMinKey() {
        if(nodeMap.isEmpty()) return "";
        return bucket.get(least).getKey();
    }
}
