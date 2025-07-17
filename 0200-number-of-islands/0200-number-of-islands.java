class Solution {
    public int numIslands(char[][] grid) {
        int island=0; 
        for(int i =0; i<grid.length; i++) {
            for(int j =0; j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    island++; 
                    dfs(grid, i,j);
                }
            }
        }
        return island; 
    }
    void dfs(char[][] grid, int i,int j) {
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j] != '1') return;

        grid[i][j] ='0';

        //left 
        dfs(grid, i, j-1);
        //right
        dfs(grid,i,j+1);
        //up
        dfs(grid,i-1,j);
        //down
        dfs(grid,i+1,j);
    }
}