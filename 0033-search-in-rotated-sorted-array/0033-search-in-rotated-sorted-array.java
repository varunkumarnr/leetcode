class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.println(pivot); 
        if(target >= nums[pivot] && target <= nums[nums.length-1]) {
            return binarySearch(nums, target, pivot, nums.length-1);
        } else {
            return binarySearch(nums, target, 0, pivot-1);
        }
    }
    int findPivot(int[] nums) {
        int start = 0, end = nums.length-1; 
        while(start < end) {
            int mid = (start + end)/2; 
            if(nums[mid] > nums[end]) {
                start = mid+1;
            }   else {
                end = mid;
            }
        }
        return end; 
    }
    int binarySearch(int[] nums, int target, int start, int end) {
        while(start<= end) {
            int mid = (start + end) /2; 
            if(nums[mid] == target) {
                return mid; 
            }
            if(nums[mid] < target) {
                start = start + 1; 
            }else {
                end =  end -1; 
            }
        }
        return -1; 
    }

}