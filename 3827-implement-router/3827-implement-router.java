// class Router {
//     int limit =0; 
//     LinkedHashMap<String, Integer> map;
//     Map<Integer, TreeMap<Integer, Integer>> query; 
//     public Router(int memoryLimit) {
//         limit = memoryLimit; 
//         map = new LinkedHashMap<>();
//         query = new HashMap<>(); 
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         String key = String.valueOf(source) + '-' + String.valueOf(destination) + '-' + String.valueOf(timestamp);
//         if(map.containsKey(key)) return false; 
//         map.put(key, timestamp); 
//         if(!query.containsKey(destination))  {
//             query.put(destination, new TreeMap<Integer, Integer>());
//         }
//         TreeMap<Integer, Integer> time = query.get(destination);
//         time.put(timestamp, time.getOrDefault(timestamp, 0) +1);
//         boolean removed = false; 
//         int timeofRemoved = 0; 
//         int dest = 0;
//         if (map.size() > limit) {
//             Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
//             if (it.hasNext()) {
//                 removed = true; 
//                 Map.Entry<String, Integer> oldest = it.next(); 
//                 dest = Integer.valueOf(oldest.getKey().split("\\-")[1]); 
//                 timeofRemoved = oldest.getValue();
//                 it.remove(); 
//             }
//         }
//         if(removed) { 
//             TreeMap<Integer, Integer> removeDest = query.get(dest); 
//             removeDest.put(timeofRemoved, removeDest.get(timeofRemoved)-1); 
//             if(removeDest.size() <=0) { 
//                 query.remove(dest); 
//             }
//         }
//         return true; 
//     }
    
//     public int[] forwardPacket() {
//         if(map.size() == 0) { 
//             return new int[0];
//         }
//         int[] result = new int[3];
//         Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
//         if(it.hasNext()) { 
//             Map.Entry<String, Integer> oldest = it.next(); 
//             String key  = oldest.getKey(); 
//             String[] s = key.split("\\-"); 
//             map.remove(key);
//             result[0] =  Integer.valueOf(s[0]); 
//             result[1] =  Integer.valueOf(s[1]); 
//             result[2] =  Integer.valueOf(s[2]); 
//             TreeMap<Integer, Integer> removeDest = query.get(result[1]);
//             removeDest.put(result[2], removeDest.get(result[2])-1); 
//             if(removeDest.size() <=0) { 
//                 query.remove(result[1]); 
//             }
//         }
//         return result; 
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         TreeMap<Integer, Integer> result = query.get(destination);
//         return result.subMap(startTime, true, endTime, true)
//             .values()
//             .stream()
//             .mapToInt(Integer::intValue)
//             .sum();
//     }
// }

class Router {
    Map<List<Integer>, Integer> mpp = new HashMap<>(); // to track duplicates
    Queue<List<Integer>> queue = new LinkedList<>(); // to store packets in FIFO order
    Map<Integer, List<Integer>> timestamps = new HashMap<>(); // for timestamps tracking
    Map<Integer, Integer> st = new HashMap<>();
    int maxSize = 0; // maxSize allowed

    public Router(int memoryLimit) { 
        maxSize = memoryLimit; 
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> packet = Arrays.asList(source, destination, timestamp);
        // checking for duplicate
        if (mpp.containsKey(packet))
            return false;
        if (queue.size() == maxSize) { // remove the first element if queue is full
            List<Integer> res = queue.poll();
            mpp.remove(res);
            int temp = res.get(1);
            st.put(temp, st.getOrDefault(temp, 0) + 1);
        }
        queue.offer(packet);
        mpp.put(packet, 1);
        timestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if(queue.isEmpty()) return new int[0];
        List<Integer> res = queue.poll();
        mpp.remove(res);
        int temp = res.get(1);
        st.put(temp, st.getOrDefault(temp, 0) + 1);
        return new int[]{res.get(0), res.get(1), res.get(2)};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if(!timestamps.containsKey(destination))
            return 0;
        List<Integer> p = timestamps.get(destination);
        int temp = st.getOrDefault(destination, 0);
        int right = lowerBound(p, startTime, temp);
        int left = upperBound(p, endTime, temp);
        return left - right;
    }

    private int lowerBound(List<Integer> p, int target, int start) {
        int l = start, r = p.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if(p.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(List<Integer> p, int target, int start) {
        int l = start, r = p.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if(p.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */