class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>(); 
        backtrack(result, k, n , new ArrayList<>(),1);
        return result; 
    }
    void backtrack(List<List<Integer>> result, int k, int n, List<Integer> curr, int start) {
        if(curr.size() == k) {
            result.add(new ArrayList<>(curr)); 
        }
        for(int i = start; i<=n;i++) {
            curr.add(i); 
            backtrack(result, k, n, curr, i+1); 
            curr.remove(curr.size()-1); 
        }
    }
}