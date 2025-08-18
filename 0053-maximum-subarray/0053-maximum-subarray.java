class Solution {
    public int maxSubArray(int[] nums) {
        int start =0, end =0, sum = Integer.MIN_VALUE, currSum = 0; 
        while(end < nums.length) {
            currSum += nums[end];
            sum = Math.max(sum, currSum); 
            while(end < nums.length && currSum < 0) {
                currSum =  0; 
                start = end;
            }
            end++;
        }
        return sum;
    }
}