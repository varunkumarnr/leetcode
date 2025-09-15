class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0; 
        for(int i =0; i< grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    numberOfIslands++; 
                    dfs(grid, i, j); 
                }
            }
        } 
        return numberOfIslands;   
    }

    void dfs(char[][] grid , int i, int j) { 
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] ='0';

        // go up 
        if(i > 0) dfs(grid, i-1, j);
        // go down
        if(i < grid.length-1) dfs(grid, i+1, j); 
        // go left 
        if(j > 0) dfs(grid, i, j-1);
        // go right
        if(j < grid[0].length-1) dfs(grid, i, j+1); 
    }
}