class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int num : nums) { 
            map.put(num, map.getOrDefault(num, 0) + 1); 
        }
        int maxElement = 0; 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) { 
            maxElement = Math.max(maxElement, entry.getValue()); 
        }
        int count = 0; 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) { 
            if(entry.getValue() == maxElement) { 
                count++; 
            }
        }
        return count * maxElement; 
    }
}