class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i =0; i<strs.length; i++) {
            String temp = strs[i]; 
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray); 
            String curr = new String(charArray);
            map.computeIfAbsent(curr, k -> new ArrayList<String>()).add(temp); 
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue()); 
        } 
        return result; 
    }
}