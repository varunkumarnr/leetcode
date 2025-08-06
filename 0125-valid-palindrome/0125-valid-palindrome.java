class Solution {
    public boolean isPalindrome(String s) {
        s.strip(); 
        int start =0; 
        int end = s.length() -1;
        if(s.length() <=1) return true;  
        while(end > start) {
            while(end > start && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } 
            while(end > start && !Character.isLetterOrDigit(s.charAt(end))) {
                end--; 
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true; 
    }
}