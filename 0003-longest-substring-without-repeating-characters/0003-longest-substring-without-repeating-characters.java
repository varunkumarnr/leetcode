class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); 
        int left  = 0 , right= 0; 
        int longest = 0; 
        while(right < s.length())  { 
            while(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) > 0) { 
                map.put(s.charAt(left) , map.get(s.charAt(left)) -1); 
                left++;  
            }
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1); 
            longest = Math.max(longest, (right-left)+1);   
            right++; 
        }
        return longest; 
    }
}