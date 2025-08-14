class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0; 
        int end= 0;  
        int maxLength = 0; 
        while(end < s.length()) {
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start)); 
                start++; 
            }
            set.add(s.charAt(end));
            maxLength = Math.max(maxLength, (end - start)+1);
            end++; 
        }
        return maxLength; 
    }
}