class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n<1) return false;
        if(n%2 != 0) return false;  
        boolean res = isPowerOfTwo(n/2);
        return res;
    }
}