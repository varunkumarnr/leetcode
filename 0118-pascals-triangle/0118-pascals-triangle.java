class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev  = new ArrayList<>(); 
        List curr = new ArrayList<>(); 
        prev.add(1); 
        result.add(new ArrayList<>(prev)); 
        for(int i = 2; i<= numRows;i++) {
            for(int j = 0; j<i;j++) {
                int currNum = 0;
                if(j==0) {
                    currNum += prev.get(j);
                } else if(j==i-1) {
                    currNum+=prev.get(j-1); 
                }else {
                    currNum = prev.get(j-1) +prev.get(j);
                }
                curr.add(currNum);
            }
            result.add(new ArrayList<>(curr));
            prev.clear();
            prev.addAll(curr);
            curr.clear();
        }
        return result; 
    }
}