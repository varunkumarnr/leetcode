// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int i=0; i<m;i++) { 
//             dp[i][0] = 1; 
//         }
//         for(int i=0; i<n; i++) { 
//             dp[0][i] = 1; 
//         }
//         for(int i = 1; i<m; i++) { 
//             for(int j =1; j< n; j++) {
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
//             }
//         }
//         return dp[m-1][n-1]; 
//     }
// }
class Solution { 
    int[][] dp; 
    public int uniquePaths(int m, int n) {
        dp  = new int[m][n]; 
        return dfs(m-1, n-1); 
    }
    int dfs(int m, int n) {
        if(m < 0 && n < 0) return 0;
        if(m==0 || n==0) return 1;
        if(dp[m][n] != 0) return dp[m][n]; 
        int right = dfs(m , n-1); 
        int down = dfs(m-1, n); 
        dp[m][n] = right + down; 
        return right + down; 
    }
}