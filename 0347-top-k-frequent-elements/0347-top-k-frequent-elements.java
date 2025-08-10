class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i =0; i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a,b) -> map.get(a)-map.get(b) 
        );
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(); 
            minHeap.offer(key); 
            while(minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        int[] result = new int[k];
        int n = minHeap.size();
        for(int i =0; i<n;i++) {
            result[i] = minHeap.poll();
        }
        return result; 
    }
}