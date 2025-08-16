class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new ArrayList<>(), 0);
        return result; 
    }
    void backtracking(int[] nums, List<Integer> curr, int start) {
        if(nums.length == curr.size()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(curr.contains(nums[i])) continue; 
            curr.add(nums[i]);
            backtracking(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}