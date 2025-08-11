class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] arr = new int[31];
        int mod = 1000000007; 
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));
        binary.reverse(); 
        for(int i= 0; i < binary.length();i++) {
            arr[i] = binary.charAt(i) -'0'; 
        }

        int powers[] = new int[binary.length()];
        Arrays.fill(powers, 1);
        int currEle = 0;  
        for(int i = 0; i<binary.length(); i++) {
            if(arr[i] !=0) {
                powers[currEle] = (int) Math.pow(2.0, Double.valueOf(i));  
                currEle++; 
            }
        }
        int output[] = new int[queries.length];
        for(int i =0; i<queries.length; i++) {
            int[] curr = queries[i];
            int currProd = 1;
            for(int j = curr[0]; j<=curr[1]; j++) {
                currProd = (int) (((long) currProd * powers[j]) % mod);

            }
            output[i] = currProd; 
        }
        return output;
    }
}