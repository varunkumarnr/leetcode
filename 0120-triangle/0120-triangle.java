// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         List<List<Integer>> dp = new ArrayList<>();  
//         for(int i = 0; i < triangle.size(); i++) {
//             List<Integer> curr = new ArrayList<>(); 
//             for(int j = 0; j < triangle.get(i).size(); j++) { 
//                 if(i ==0) { 
//                     curr.add(triangle.get(i).get(j)); 
//                 } else  {
//                     if(j == 0) { 
//                         curr.add(triangle.get(i).get(j) + dp.get(i-1).get(j)); 
//                     } else if( j == triangle.get(i).size()-1){ 
//                         curr.add(triangle.get(i).get(j) + dp.get(i-1).get(j-1));
//                     } else {
//                         curr.add(triangle.get(i).get(j) + Math.min(dp.get(i-1).get(j-1),dp.get(i-1).get(j)));
//                     }
//                 }
//             }
//             dp.add(curr); 
//         }
//         return dp.get(dp.size() - 1).stream().min(Integer::compareTo).get();
//     }
// }

class Solution { 
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) { 
        int n = triangle.size(); 
        dp = new int[n][n];
        for(int i = 0; i < triangle.size(); i++) { 
            Arrays.fill(dp[i], Integer.MIN_VALUE); 
        }
        return dfs(triangle, 0, 0); 
    }
    int dfs(List<List<Integer>> triangle, int i , int j)  { 
        if(i == triangle.size() -1) { 
            return triangle.get(i).get(j); 
        }
        if(dp[i][j] != Integer.MIN_VALUE)  { 
            return dp[i][j];
        } 
        int down = dfs(triangle, i+1, j);
        int diag = dfs(triangle, i+1, j+1);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag); 
    }
}