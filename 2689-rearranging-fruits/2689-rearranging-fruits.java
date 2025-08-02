class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int x: basket1)  map.put(x, map.getOrDefault(x,0)+1);
        for(int x: basket2)  map.put(x, map.getOrDefault(x,0)-1);

        List<Integer> toSwap = new ArrayList<>(); 
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(); 
            int value = entry.getValue(); 
            if(value % 2!=0) return -1; 
                    for (int i = 0; i < Math.abs(value) / 2; i++) {
                     toSwap.add(key);
            }
            minValue = Math.min(minValue, key);
        }
        Collections.sort(toSwap);
         long cost = 0;
            for (int i = 0; i < toSwap.size() / 2; i++) {
                cost += Math.min(toSwap.get(i), 2 * minValue);
            }
    return cost; 
    }
}