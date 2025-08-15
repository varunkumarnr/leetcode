class Solution {
    public int myAtoi(String s) {
        s= s.trim(); 
        boolean isPositive = true; 
        String withoutSign = "";
        int MIN = Integer.MIN_VALUE; // -2147483648
        int MAX = Integer.MAX_VALUE;
        if(s.length() ==0) return 0;
        if(s.charAt(0) == '-') {
            isPositive = false;
            withoutSign = s.substring(1,s.length()); 
        } else if(s.charAt(0) == '+')  {
            withoutSign = s.substring(1, s.length());  
        } else { 
            withoutSign = s; 
        }
        StringBuilder withoutChar  = new StringBuilder();
        for(char c : withoutSign.toCharArray()) {
            if(!Character.isDigit(c)) {
                break; 
            }
            withoutChar.append(c);
        }
        if(withoutChar.toString().equals("")) {
            withoutChar.append('0'); 
        }
        if (withoutChar.length() == 0) return 0;

        int result = 0;
        for (int i = 0; i < withoutChar.length(); i++) {
            int digit = withoutChar.charAt(i) - '0';
            if (isPositive && result > (MAX - digit) / 10) {
                return MAX;
            }
            if (!isPositive && -result < (MIN + digit) / 10) {
                return MIN;
            }
            result = result * 10 + digit;
        }
        return isPositive ? result : -result;

    }
}