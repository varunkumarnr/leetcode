class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), 0); 
        return result; 
    }
    void backtracking(int[] nums, List<Integer> curr, int start) { 
        result.add(new ArrayList<>(curr)); 
        for(int i = start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;  
            curr.add(nums[i]);
            backtracking(nums, curr, i+1); 
            curr.remove(curr.size()-1);
        }
    }
}