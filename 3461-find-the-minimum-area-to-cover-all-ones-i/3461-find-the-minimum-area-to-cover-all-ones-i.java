class Solution {
    public int minimumArea(int[][] grid) {
        int maxCol = 0, minCol = Integer.MAX_VALUE;
        int maxRow = 0, minRow = Integer.MAX_VALUE;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxCol = Math.max(maxCol, j);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
minRow = Math.min(minRow, i);                }
            }
        }
        // System.out.println(maxCol +  " " +  maxRow + " " + minCol + " " +  minRow); 
        int area = (((maxCol - minCol) + 1) * ((maxRow - minRow)+1));
        return area; 
    }
}