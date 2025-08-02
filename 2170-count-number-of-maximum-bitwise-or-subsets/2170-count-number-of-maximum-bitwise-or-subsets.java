class Solution {
    int count = 0; 
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i = 0; i<nums.length; i++) {
            maxOr |= nums[i];
        }
        backtrack(nums, maxOr, 0, new ArrayList<>(), 0);  
        return count; 
    }
    void backtrack(int[] nums, int maxOr, int start, List<Integer> tempList, int curr) {
        if(maxOr == curr) {
            count++; 
        }
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            curr = helper(tempList);
            backtrack(nums, maxOr, i+1, tempList, curr);
            tempList.remove(tempList.size() -1); 
        }
    } 
    int helper(List<Integer> nums) { 
        int currOr = 0;
        for(int i = 0; i<nums.size(); i++) {
            currOr |= nums.get(i);
        }
        return currOr; 
    }
}