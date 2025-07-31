class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int curr = 0;
        for(int i =0; i<arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
        }

        for(int j=0; j<arr2.length; j++) {
            while(map.containsKey(arr2[j])) {
                arr1[curr] = arr2[j];
                map.put(arr2[j], map.get(arr2[j])-1);
                if(map.get(arr2[j]) == 0) {
                    map.remove(arr2[j]);
                }
                curr += 1;
            }
        }
        List<Integer> remaining = new ArrayList<>(); 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            remaining.add(entry.getKey()); 
        }
        Collections.sort(remaining);

        for(int i = 0; i < remaining.size(); i++) {
            while(map.containsKey(remaining.get(i))) {
                arr1[curr] = remaining.get(i); 
                map.put(remaining.get(i), map.get(remaining.get(i))-1);
                if(map.get(remaining.get(i)) == 0) {
                    map.remove(remaining.get(i));
                }
                curr++; 
            }
        }
        return arr1;
    }
}