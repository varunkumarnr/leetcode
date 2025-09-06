class Solution {
    public int search(int[] nums, int target) {
        int i = findpivot(nums); 
        if(i == 0) {
            return binarySearch(nums, 0, nums.length-1, target);
        } 
        if(target >= nums[0] && target <= nums[i-1]) {
          return  binarySearch(nums, 0, i-1, target); 
        }  else {
            return binarySearch(nums, i, nums.length-1, target); 
        }
    }

    int binarySearch(int[] nums, int start, int end,int  target) {
        while(end >= start) {
            int mid = (start + end)/ 2; 
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1; 
            } else {
                end = mid -1; 
            }
        }
        return -1;
    }

    int findpivot(int[] nums) {
        int start = 0; 
        int end = nums.length -1; 
        while(end > start) {
            int mid = (start + end) /2; 
            if(nums[mid] > nums[end]) {
                start  = mid + 1; 
            } else { 
                end = mid; 
            }
        }
        return end; 
    }
}