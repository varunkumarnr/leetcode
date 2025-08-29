class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0; 
        int count = 1;
        int curr = nums[0]; 
        for(int i = 1; i< nums.length; i++) {
            if(curr == nums[i]) count++; 
            else{
                count--; 
                if(count < 0) {
                    curr = nums[i]; 
                    count =1; 
                }
            }
        }
        return curr; 
    }
}