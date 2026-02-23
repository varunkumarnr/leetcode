class Solution {
    public int countPrimeSetBits(int left, int right) {
        int primeCount = 0; 
        for (int i = left; i<= right; i++) { 
            int setCount = 0; 
             for(int n = 31; n>=0; n--) { 
                if(((i >> n) & 1) == 1) { 
                    setCount++; 
                } 
            }
            System.out.println(setCount); 
           
            boolean prime = true;  
             if(setCount < 2) {
                prime= false; 
             };
            for(int j = 2; j< setCount; j++) { 
                if(setCount % j == 0) { 
                    prime = false; 
                    break; 
                }
            }
            if(prime) {
                primeCount++; 
            }
        }
       return primeCount; 
    }
}