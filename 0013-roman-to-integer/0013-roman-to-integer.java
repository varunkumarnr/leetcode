class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V',5);
        map.put('X',10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        boolean lastTakenCare = false; 
        if(s.length() == 0) return 0; 
        if(s.length() == 1) return map.get(s.charAt(0));
        for(int i = 0; i<s.length()-1; i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                total += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                if((i+1)  == s.length()-1) {
                    lastTakenCare = true; 
                }
                i++; 
                continue;
            }
            total += map.get(s.charAt(i));
        }
        if(!lastTakenCare) {
            total += map.get(s.charAt(s.length()-1));
        }
        return total; 
    }
}