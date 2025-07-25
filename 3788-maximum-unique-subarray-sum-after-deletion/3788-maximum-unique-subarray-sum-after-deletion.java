class Solution {
    public int maxSum(int[] nums) {
        int sum =0;
        Arrays.sort(nums);
        int prev = 0;
        if(nums[nums.length-1] <= 0) {
            return nums[nums.length-1];
        }
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != prev && nums[i] >0) {
                sum += nums[i];
                prev = nums[i];
            }
        }
        return sum; 
    }  
}