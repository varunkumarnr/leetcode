class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<grid.length; i++) {
            for(int j =0; j<grid[0].length; j++) { 
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } 
            }
        }
        int steps = 0; 
        while(!queue.isEmpty()) {
            System.out.println(queue.size());
            boolean updated=false; 
            int n = queue.size();
            for(int i = 0; i<n; i++) {
                int[] curr = queue.poll();
                int r  = curr[0];
                int c  = curr[1]; 
                if(r>0 && grid[r-1][c] == 1 ) {
                    queue.offer(new int[]{r-1, c});
                    grid[r-1][c] = -1;
                    updated = true; 
                } 
                if(r<grid.length-1 && grid[r+1][c] == 1) {
                    queue.offer(new int[]{r+1,c }); 
                    grid[r+1][c] =-1;
                    updated = true; 
                }
                if(c>0 && grid[r][c-1] == 1 ) { 
                    queue.offer(new int[]{r, c-1}); 
                    grid[r][c-1] =-1;
                    updated = true; 
                } 
                if(c<grid[0].length-1 && grid[r][c+1] == 1)  {
                queue.offer(new int[]{r,c+1 });
                grid[r][c+1] = -1; 
                updated = true; 
                }
            }
            if (updated) steps++; 
        }

        for(int i = 0; i<grid.length; i++) {
            for(int j =0; j<grid[0].length; j++) { 
                if(grid[i][j] == 1) {
                     return -1;
                }
            }
        }
        return steps;   
    }
}