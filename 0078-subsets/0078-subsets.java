class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(nums, result, tempList, 0);
        return result; 
    }
    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
        result.add(new ArrayList<>(tempList)); 
        if(start>= nums.length) return; 
        for(int  i = start; i<nums.length; i++) {
            tempList.add(nums[i]);     // 1,2,3
            backtrack(nums, result, tempList, i+1); //2
            tempList.remove(tempList.size()-1); 
        }
    }
}