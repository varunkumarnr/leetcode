class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();  
        for(int i = 0; i < triangle.size(); i++) {
            List<Integer> curr = new ArrayList<>(); 
            for(int j = 0; j < triangle.get(i).size(); j++) { 
                if(i ==0) { 
                    curr.add(triangle.get(i).get(j)); 
                } else  {
                    if(j == 0) { 
                        curr.add(triangle.get(i).get(j) + dp.get(i-1).get(j)); 
                    } else if( j == triangle.get(i).size()-1){ 
                        curr.add(triangle.get(i).get(j) + dp.get(i-1).get(j-1));
                    } else {
                        curr.add(triangle.get(i).get(j) + Math.min(dp.get(i-1).get(j-1),dp.get(i-1).get(j)));
                    }
                }
            }
            dp.add(curr); 
        }
        return dp.get(dp.size() - 1).stream().min(Integer::compareTo).get();
    }
}