class Solution {
    public int[] productExceptSelf(int[] nums) {
        // left prefix product 
        // [1,2,3,4]

        // i would get 

        // [1, 1, 2,6] 

        // right prefix product 

        // [24,12,4,1]
        // Set<Integer> seen  = new HashSet<Integer>();
        int[] leftPrefix = new int[nums.length]; 
        for(int i = 0; i< nums.length; i++) { 
            if(i == 0) {
                leftPrefix[i] = 1;
                continue;
            }
            leftPrefix[i] =  nums[i-1] * leftPrefix[i-1]; 
        }
        int[] rightPrefix = new int[nums.length]; 
        for(int i = nums.length-1 ; i>=0; i--) {
            if(i == nums.length-1) {
                rightPrefix[i] = 1; 
                continue; 
            }
            rightPrefix[i] = nums[i+1] * rightPrefix[i+1]; 
        }
        int output[] = new int[nums.length]; 
        for(int i =0; i< nums.length; i++) {
            output[i] = leftPrefix[i] * rightPrefix[i];
        }
        return output; 
    }
}