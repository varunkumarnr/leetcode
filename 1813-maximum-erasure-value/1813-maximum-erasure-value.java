class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0, end = 0; 
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int currSum=0; 
        while(end < nums.length) {
            while(end < nums.length && !set.contains(nums[end])) {
                set.add(nums[end]);
                currSum += nums[end];  
                end++; 
            }
            maxSum = Math.max(maxSum, currSum);
            set.remove(nums[start]);
            currSum -= nums[start]; 
            start++; 
        }
        return maxSum; 
    }
}