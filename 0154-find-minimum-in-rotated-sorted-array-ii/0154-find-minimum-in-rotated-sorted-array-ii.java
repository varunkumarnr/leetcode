class Solution {
    public int findMin(int[] nums) {
        /* 
        [3,1,3] 0 , 2 | 0 < 2   mid = 1 1 >3 false  1<3  fasle 
        

        */

        int start = 0, end = nums.length -1;
        while(start < end) {      
            int mid = (start + end) /2; 
            if(nums[mid] > nums[end]) { 
                start = mid + 1; 
            } else if(nums[mid] < nums[end]) {
                end = mid; 
            } else {
                end--;
            }
        }
        return nums[start];
    }
}