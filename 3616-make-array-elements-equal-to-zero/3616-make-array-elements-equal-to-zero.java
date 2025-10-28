class Solution {
    public int countValidSelections(int[] nums) {
        int result = 0; 
        for(int i  = 0 ; i<nums.length; i++) { 
            if(nums[i] == 0) { 
                int[] cloneLeft = nums.clone(); 
                if(isValid(cloneLeft, i , 1)) {  // left 
                    result++; 
                } 
                int[] cloneRight = nums.clone(); 
                if(isValid(cloneRight,i,  -1)) { // right 
                    result++; 
                }
            }
        }
        return result; 
    }
    boolean isValid(int[] nums, int curr, int dir) {
    int n = nums.length;

    while (curr >= 0 && curr < n) {
        if (nums[curr] == 0) {
            curr += dir;
        } else {
            nums[curr]--;
            dir = -dir;
            curr += dir;
        }
    }

    for (int x : nums) {
        if (x != 0) return false;
    }
    return true;
}
}
