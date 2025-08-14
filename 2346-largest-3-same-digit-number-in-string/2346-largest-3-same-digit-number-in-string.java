class Solution {
    public String largestGoodInteger(String num) {
        String maxNumber = ""; 
        int max = -1; 
        int curr = 1;
        int counter = 1;  
        while(curr < num.length()) { 
            if(num.charAt(curr-1) == num.charAt(curr)) {
                counter +=1; 
            }
            if(num.charAt(curr-1) != num.charAt(curr)) {
                counter = 1;
            }
            if(counter == 3) {
                max = Math.max(max, num.charAt(curr) - '0'); 
                counter = 1; 
            }
            curr++; 
        }
        maxNumber  = max == -1  ?  "" : String.valueOf(max) + String.valueOf(max) + String.valueOf(max); 
        return maxNumber; 
    }
}