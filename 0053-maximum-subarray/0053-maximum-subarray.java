class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0; 
        int maxSum = Integer.MIN_VALUE; 
        if(nums.length == 1) return nums[0];
        for(int i = 0; i<nums.length; i++) {
            curr = curr + nums[i];
            maxSum = Math.max(maxSum, curr); 
            if(curr < 0) curr = 0;
        }       
        return maxSum;
    }
}