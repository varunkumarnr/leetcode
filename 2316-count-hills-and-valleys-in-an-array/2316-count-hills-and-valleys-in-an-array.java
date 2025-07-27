class Solution {
    public int countHillValley(int[] nums) {
        
        int prev = nums[0]; 
        int next = nums[0]; 
        int result = 0;
        for(int i = 1; i<nums.length-1; i++) {
            prev = nums[i-1];
            while(i< nums.length-2 && nums[i] == nums[i+1]){
                i++;
            }
            next = nums[i+1];
            if(prev < nums[i] && next<nums[i]) {
                result = result+1;
            } if(prev > nums[i] && next > nums[i]) {
                result = result + 1;
            }
         }
         return result; 
    }
}