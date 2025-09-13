class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> freqmap= new HashMap<>();
        int maxVowel = 0; 
        int maxConst = 0;  
        for(char c: s.toCharArray()) { 
            freqmap.put(c, freqmap.getOrDefault(c, 0) +1); 
            if(c == 'a' || c== 'e' || c=='i' ||c=='o' ||c=='u') {
                maxVowel = Math.max(maxVowel, freqmap.get(c));
            } else  {
                maxConst = Math.max(maxConst, freqmap.get(c)); 
            }
        }
        return maxVowel + maxConst; 
    }
}