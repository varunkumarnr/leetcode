class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    void backtracking(int[] candidates, int remaining, List<Integer> curr, int start) {
        if(remaining == 0) {
            result.add(new ArrayList<>(curr)); 
        }
        if(remaining < 0) {
            return; 
        }
        for(int i = start; i<candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue; 
            curr.add(candidates[i]);
            backtracking(candidates, remaining - candidates[i], curr, i+1);
            curr.remove(curr.size() -1);
        }
    }
}