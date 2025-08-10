class Solution {
    public int[] productExceptSelf(int[] nums) {  
        int totalProduct = 1;
        boolean zeroExists = false; 
        int[] prefix = new int[nums.length];
        Arrays.fill(prefix, 1);  
        int[] suffix = new int[nums.length];
        Arrays.fill(suffix, 1);  
        for(int i =1; i<nums.length;i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        for(int i = nums.length-2; i>=0; i--) {
            suffix[i] =  nums[i+1] * suffix[i+1]; 
        }
        for(int i =0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }
}