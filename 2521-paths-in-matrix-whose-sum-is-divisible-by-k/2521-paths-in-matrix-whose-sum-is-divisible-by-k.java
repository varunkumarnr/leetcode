class Solution {
    Integer[][][] dp; 
    public int numberOfPaths(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k];
        return dfs(grid, 0, 0, 0, k);  
    }
    int dfs(int[][] grid, int mod , int i, int j, int k) { 
        mod = (mod + grid[i][j]) % k;
        if(i == grid.length -1 && j == grid[0].length-1) { 
            return mod == 0 ? 1 : 0;  
        }
        if(dp[i][j][mod] != null) return dp[i][j][mod];
        int ways = 0; 
        if(i< grid.length-1)  {
           ways =  (ways + dfs(grid, mod , i+1, j, k)) % 1000000007; 
        }     
        if(j< grid[0].length-1)    { 
           ways =  (ways + dfs(grid, mod, i, j+1, k)) % 1000000007; 
        } 
        dp[i][j][mod] = ways;
        return ways; 
    }
}