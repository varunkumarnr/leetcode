// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         int m = dungeon.length; 
//         int n = dungeon[0].length; 
        
//         int[][][] dp = new int[m][n][2];
        
//         dp[0][0][0] = dungeon[0][0];
//         dp[0][0][1] = dungeon[0][0];
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 && j == 0) continue; 
                
//                 if (i == 0) { 
//                     int curr = dp[i][j-1][0] + dungeon[i][j]; 
//                     int minSoFar = Math.min(dp[i][j-1][1], curr);
//                     dp[i][j][0] = curr;
//                     dp[i][j][1] = minSoFar;
//                 }
//                 else if (j == 0) { 
//                     int curr = dp[i-1][j][0] + dungeon[i][j]; 
//                     int minSoFar = Math.min(dp[i-1][j][1], curr);
//                     dp[i][j][0] = curr;
//                     dp[i][j][1] = minSoFar;
//                 } 
//                 else { 
//                     int fromTop = dp[i-1][j][0] + dungeon[i][j];
//                     int minFromTop = Math.min(dp[i-1][j][1], fromTop);
                    
//                     int fromLeft = dp[i][j-1][0] + dungeon[i][j];
//                     int minFromLeft = Math.min(dp[i][j-1][1], fromLeft);
                    
//                     if (minFromTop > minFromLeft) {
//                         dp[i][j][0] = fromTop;
//                         dp[i][j][1] = minFromTop;
//                     } else {
//                         dp[i][j][0] = fromLeft;
//                         dp[i][j][1] = minFromLeft;
//                     }
//                 }
//             }
//         }
//         System.out.println(Arrays.deepToString(dp));
        
//         int minPathSum = dp[m-1][n-1][1];
//         return minPathSum <= 0 ? -minPathSum + 1 : 1; 
//     }
// }
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1]  = Math.max(1, 1  + ((-1) * dungeon[m-1][n-1])); 
        for(int i = m -1; i>= 0; i--) { 
            for(int j = n-1; j >=0 ; j--) { 
                if( i == m-1 && j == n-1) continue;
                if(i==m-1) {
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                } else if(j == n-1) {
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                } else { 
                    dp[i][j] = Math.max(1, Math.min(dp[i][j+1] - dungeon[i][j], dp[i+1][j] - dungeon[i][j])); 
                }
            }
        }
        System.out.println(Arrays.deepToString(dp)); 
        return dp[0][0]; 
    }
} 