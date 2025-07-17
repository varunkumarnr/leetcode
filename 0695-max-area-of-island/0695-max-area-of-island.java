class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandSize = 0; 
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                int currIslandSize=0; 
                if(grid[i][j] ==1) {
                  currIslandSize= dfs(grid, i, j); 
                  maxIslandSize = Math.max(maxIslandSize, currIslandSize);
                //   System.out.println(currIslandSize);
                }
            }
        }
        return maxIslandSize;
    }
    int dfs(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j] != 1)      {
            return 0;
        }
        int size = 1;
        // System.out.println(currIslandSize); 
        grid[i][j] = 0; 

        // left
        size+= dfs(grid, i, j-1); 
        size+= dfs(grid, i, j+1);
        size+= dfs(grid, i-1, j); 
        size+= dfs(grid, i+1, j);

        return size; 
    }
}