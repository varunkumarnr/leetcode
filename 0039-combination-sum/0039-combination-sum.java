class Solution {
    List<List<Integer>> result  = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, new ArrayList<>(), 0); 
        return result; 
    }
    void backtracking(int[] candidates, int target, List<Integer> curr, int start) {
        // int sum = curr.stream().mapToInt(Integer::intValue).sum();
        if(target == 0) {
            result.add(new ArrayList<>(curr));
        }
        if(target < 0) {
            return; 
        }
        for(int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]); 
            backtracking(candidates, target - candidates[i], curr, i); 
            curr.remove(curr.size()-1);
        }
    }
}