class Solution {
    public int[] sumZero(int n) {
        boolean isOdd = n % 2 != 0 ? true : false; 
        int half = n/2; 
        int[] result = new int[n];
        if(isOdd) { 
        for(int i = 0; i< half; i++) {
                result[i] = -(i+1);
                result[half + i + 1] = i+1;  
        }
        } else {
            for(int i = 0; i< half; i++) {
                result[i] = -(i+1);
                result[half + i] = i+1;  
        }
        }
        return result;
    }
}