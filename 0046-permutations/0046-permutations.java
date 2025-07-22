class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, 0, new ArrayList<>());
        return result; 
    }
    void backtracking(int[] nums, List<List<Integer>> result, int start, List<Integer> curr) { 
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr)); 
            return; 
        }
        for(int i = 0; i< nums.length; i++) {
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]); 
            backtracking(nums, result, i+1, curr); 
            curr.remove(curr.size() -1); 
        }
    }
}