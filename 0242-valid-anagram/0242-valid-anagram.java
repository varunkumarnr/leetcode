class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        if(s.length() != t.length()) {
            return false;
        }
        for(int i =0; i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>(); 
        for(int i =0; i<t.length();i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }
        if(map.size() != map2.size()) return false;
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}