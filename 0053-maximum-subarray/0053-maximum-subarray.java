class Solution {
    public int maxSubArray(int[] nums) {
        int start =0, end =0, sum = Integer.MIN_VALUE, currSum = 0; 
        while(end < nums.length) {
            currSum += nums[end]; 
            end++; 
            sum = Math.max(sum, currSum); 
            while(currSum < 0) {
               currSum = currSum - nums[start]; 
               start++;
            }
        }
        return sum;
    }
}