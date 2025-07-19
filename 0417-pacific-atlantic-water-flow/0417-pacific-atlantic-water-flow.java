class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
        dfs(i, 0, heights, pacific, heights[i][0]);
        dfs(i, heights[0].length - 1, heights, atlantic, heights[i][heights[0].length - 1]); 
    }
    for (int j = 0; j < heights[0].length; j++) {
        dfs(0, j, heights, pacific, heights[0][j]);
        dfs(heights.length - 1, j, heights, atlantic, heights[heights.length - 1][j]);
    }

        for(int i =0; i<pacific.length; i++) {
            for(int j = 0; j <pacific[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(new Integer[]{i,j}));
                }
            }
        }
        return result; 
    }
    void dfs(int row,int col, int[][] heights, boolean[][] mark  ,int prev) {
        if(row < 0 || col <0 || row >= heights.length || col >= heights[0].length || prev > heights[row][col] || mark[row][col] == true) return;  
        mark[row][col] = true;
        prev = heights[row][col];
        dfs(row-1, col, heights,mark, prev);
        dfs(row+1, col, heights,mark, prev);
        dfs(row, col-1, heights,mark, prev);
        dfs(row, col+1, heights,mark, prev);        
    }
}