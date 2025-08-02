class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        int curr = 0; 
        while(curr <= n) {
            int temp = curr;
            int count = 0; 
            while(temp != 0) {
                if((temp &1) == 1) count++; 
                temp = temp >> 1; 
            }
            arr[curr] = count;
            curr++;
        }
        return arr;
     }
}