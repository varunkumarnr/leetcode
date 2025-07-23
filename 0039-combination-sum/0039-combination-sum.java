class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(candidates);
        backtracking(result,candidates , new ArrayList<>(), target, 0, 0); 
        return result; 
    }
    void backtracking(List<List<Integer>> result, int[] candidates, List<Integer> curr, int target, int start, int currSum) {
        if(currSum == target) { 
            result.add(new ArrayList<>(curr)); 
            return; 
        }
        for(int i = start; i<candidates.length; i++) {
            currSum += candidates[i];
            curr.add(candidates[i]);
            if(currSum > target) {
                int last = curr.remove(curr.size() - 1);
                currSum -= last;
                continue;
            }
            backtracking(result , candidates, curr, target, i, currSum); 
            int last = curr.remove(curr.size() - 1);
            currSum -= last;
        }
    } 
}