class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
                if(m==0 && n==0) return grid[0][0];

        int[][] dp = new int[m][n];
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n; j++) {
                if(i == 0 && j == 0 ) {
                    dp[i][j] = grid[i][j];
                }  else {
                    int down =  i>0 ? dp[i-1][j] :  Integer.MAX_VALUE; 
                    int right = j > 0 ? dp[i][j-1]: Integer.MAX_VALUE; 
                    dp[i][j] = grid[i][j] + Math.min(down, right);
                }
            }
        }
        return dp[m-1][n-1];
    }
}