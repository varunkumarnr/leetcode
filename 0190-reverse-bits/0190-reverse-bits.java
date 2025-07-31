class Solution {
   public int reverseBits(int n) {
        StringBuilder s = new StringBuilder(); 
        for (int i = 0; i < 32; i++) {
            s.append(n & 1);         
            n >>>= 1;                
        }
        return (int) Long.parseLong(s.toString(), 2); 
    }
}