class LRUCache {
    Map<Integer, Integer> map;
    int limit = 0; 
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 1.00f, true);
        limit = capacity; 
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.put(key, value);
        } else {
        if(map.size() < limit) {
            map.put(key, value);
        } else {
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int keys = entry.getKey();
                map.remove(keys);
                break;
            }
            map.put(key, value);
        }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */