class Solution {
    public String longestPalindrome(String s) {
        String maxString = ""; 
        int maxLength  = 0; 
        for(int i = 0; i< s.length(); i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);
            String curr = odd.length() > even.length() ? odd : even;
            if(curr.length() > maxLength) {
                maxString = curr; 
                maxLength = Math.max(maxLength, curr.length());
            }
        }   
        return maxString;
    }

    String expand(String s, int i, int j) {
        while(i >= 0 && j < s.length()&& s.charAt(i) == s.charAt(j)) {
            i--; 
            j++;
        }
        return s.substring(i+1,j);
    }      
}