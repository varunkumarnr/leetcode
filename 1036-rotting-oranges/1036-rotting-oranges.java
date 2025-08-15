class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        int time = -1; 
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for (int j =0; j<m; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int len = queue.size(); 
            while(len > 0) {
                int[] curr = queue.poll(); 
                int row = curr[0];
                int col = curr[1]; 
                if(row > 0 && grid[row-1][col] == 1){ 
                    queue.offer(new int[]{row-1,col}); 
                    grid[row-1][col] =2; 
                } 
                if(row < n -1 && grid[row +1][col] ==1)
                { 
                    queue.offer(new int[]{row+1,col});
                    grid[row+1][col] = 2;     
                }
                if(col > 0 && grid[row][col-1] == 1) {
                     queue.offer(new int[]{row, col-1});
                     grid[row][col-1] = 2;   
                }  
                if(col < m-1 && grid[row][col+1] == 1) { 
                    queue.offer(new int[] {row, col+1});
                    grid[row][col+1] = 2;     
                }
                len--;  
            }
            time += 1; 
        }
       for(int i = 0; i < n; i++) {
            for (int j =0; j<m; j++) {
                if(grid[i][j] == 1) {
                    return -1; 
                }
            }
       }
       return time == -1 ? 0 : time;
    }
}