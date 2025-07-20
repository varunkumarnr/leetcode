class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i< nums.length; i++) {
            if(nums[i] >0 && !set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }  
        return nums.length + 1;      
    } 
}