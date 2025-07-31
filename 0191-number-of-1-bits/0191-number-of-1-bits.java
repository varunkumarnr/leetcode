class Solution {
    public int hammingWeight(int n) {
        int count = 0; 
       while(n!=0) {
          // compare n with 1 with and biwise operator
          /* 
            000011
            000001
            000001 == 1
            if we and 1 then we will know the last bit is one 

            then right shift to remove last bit and compare second last till n beocmes 0 damn
          */
          if((n & 1) == 1) {
            count++; 
          } 
          n= n>>>1;
       }
       return count; 
    }
}