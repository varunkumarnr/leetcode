class Solution {
    public void sortColors(int[] nums) {
        int zero_counter = 0;
        int one_counter = 0;
        int two_counter = 0; 
        for(int i =0; i< nums.length; i++) {
            if(nums[i] == 0) {
                zero_counter++; 
            } else if(nums[i] == 1) {
                one_counter++;
            } else { 
                two_counter++;
            }
        }
        int curr = 0; 
        while(curr< nums.length) { 
            while(zero_counter > 0) {
                nums[curr] = 0; 
                curr++;
                zero_counter--;  
            }
            while(one_counter >0) {
                nums[curr] = 1; 
                curr++; 
                one_counter--; 
            } 
            while(two_counter > 0) {
                nums[curr] = 2; 
                curr++; 
                two_counter--; 
            }
        }
    }
}