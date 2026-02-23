class Solution {
    public int binaryGap(int n) {
        StringBuilder sb = new StringBuilder(); 
        for (int i = 31; i >= 0; i--) {
            sb.append((n>>i)&1); 
        }
        String s = sb.toString();
        int last = -1;  
        int biggest = 0; 
        for(int i = 0 ; i<s.length(); i++) { 
            if(s.charAt(i) == '1') { 
                if(last == -1) { 
                    last = i; 
                } else { 
                    biggest = Math.max(biggest, i - last); 
                    last= i; 
                }
            }
        }   
        return biggest;
    }
}