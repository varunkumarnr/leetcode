class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1); 
        }
        HashMap<Character, Integer> windowMap = new HashMap<>(); 
        int left = 0; 
        int right = 0;
        int exactMatch = 0;
        int minSize = Integer.MAX_VALUE; 
        String minString = "";
        while(right < s.length()) {
            char curr = s.charAt(right); 
            windowMap.put(curr, windowMap.getOrDefault(curr,0) +1); 
            if(map.containsKey(s.charAt(right)) && windowMap.get(curr).equals(map.get(curr))) {
                exactMatch +=1; 
            }
            while(exactMatch == map.size()) {
                if((right-left)+1 < minSize ) {
                    minString = s.substring(left,right+1);
                    minSize = (right-left)+1;
                }
                windowMap.put(s.charAt(left), windowMap.get(s.charAt(left))-1);
                if(map.containsKey(s.charAt(left)) && windowMap.getOrDefault(s.charAt(left),0) < map.get(s.charAt(left)))          
                {
                    exactMatch--; 
                }
                if(windowMap.get(s.charAt(left)) == 0) {
                    windowMap.remove(s.charAt(left));
                } 
                left++; 
            }
            right++;
        }
        return minString;
    }
}