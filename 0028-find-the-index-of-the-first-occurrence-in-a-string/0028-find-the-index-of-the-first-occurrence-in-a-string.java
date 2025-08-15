class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1; 
        int requiredLength = needle.length(); 
        
        for(int i = 0; i<=(haystack.length()-needle.length()); i++) {
            int curr = i; 
            int currentCheck = 0; 
            while(curr < haystack.length() &&  haystack.charAt(curr) == needle.charAt(currentCheck)) {
                currentCheck +=1; 
                curr++;
                if(currentCheck == requiredLength) {
                    return curr - requiredLength; 
                }
            }
        }
        return -1; 
    }
}