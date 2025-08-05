class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0; int right = 0;
        int maxFreq = 0; 
        char maxFreqChar = s.charAt(0); 
        int maxLength = 0;  
        while(right< s.length()) {
            char curr = s.charAt(right);
            map.put(curr , map.getOrDefault(curr, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(curr)); 
            int otherCharacters = (right-left) +1 - maxFreq;
            while(left < right && otherCharacters > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1); 
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                otherCharacters--;
                left++; 
            }
            maxLength = Math.max(maxLength, (right - left) +1); 
            right++;
        }
        return maxLength;
    }
}