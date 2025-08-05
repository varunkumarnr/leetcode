class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length -1; 
        while(start < end) {
            int mid = (start + end) /2;  // 2 + 3 / 2  
            if(nums[mid] > nums[end]) {
                start = mid + 1;    // 2 , 3
            } else {
                end = mid; 
            }
        }
        return nums[end]; 
    }
}