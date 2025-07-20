class Solution {
    public long splitArray(int[] nums) {
        long sumA = 0, sumB =0; 
        for(int i = 0; i<nums.length;i++) {
            if(checkPrime(i)) {
                sumA+=nums[i];
            } else {
                sumB+= nums[i];
            }
        }
        return Math.abs(sumA-sumB);
    }

    public boolean checkPrime(int a) {
        if(a < 2) {
            return false; 
        }
        if(a!=2 && a%2==0) return false; 
        int n = (int) Math.sqrt(a); 
        for(int i =3; i<=n; i+=2) {
            if( a%i == 0) {
                return false;
            }
        }
        return true;
    }
}