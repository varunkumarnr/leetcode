class RandomizedSet {
    Map<Integer, Integer> map; 
    List<Integer> list; 

    public RandomizedSet() {
        map = new HashMap<>(); 
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
        map.put(val, list.size());
        list.add(val);
        return true; 
        }
        return false; 
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val); 
            map.remove(val); 
            int lastIndexValue = list.get(list.size()-1); 
            list.set(index, lastIndexValue); 
            if(map.containsKey(lastIndexValue))  map.put(lastIndexValue, index);
            list.remove(list.size()-1);
            return true; 
        }
        return false; 
    }
    
    public int getRandom() {
        int size = map.size();
        return list.get((int) (Math.random() * size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */