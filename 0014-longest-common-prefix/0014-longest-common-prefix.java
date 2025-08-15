class Solution {
    public String longestCommonPrefix(String[] strs) {
        int start = 0;
        while(start < strs[0].length()) {
            for(String str: strs) {
                char curr = strs[0].charAt(start); 
                if(start >= str.length() || str.charAt(start) != curr) {
                    return strs[0].substring(0,start);
                }     
            }  
            start +=1;  
        } 
        return start  == 0 ? "" : strs[0].substring(0,start); 
    }
}