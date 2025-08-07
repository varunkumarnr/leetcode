class Solution {
    public String longestPalindrome(String s) {
        String maxString = ""; 
        for(int i = 0; i<s.length(); i++) {
            String s1 = expand(s, i,i);
            String s2 = expand(s,i,i+1); 
            if(Math.max(s1.length(), s2.length()) > maxString.length()) {
                if(s1.length() >= s2.length()) {
                    maxString = s1;
                } else {
                    maxString = s2; 
                }
            }
        }   
        return maxString;     
    }
    String expand(String s, int left, int right) {
        while(right < s.length() && left >=0  && s.charAt(left) == s.charAt(right)) {
            left--; 
            right++; 
        }
        return s.substring(left+1, right);
    }
}