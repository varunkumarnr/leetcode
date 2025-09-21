class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0) { 
            return 0;
        }
        if(grid[0][0] != 0 || grid[grid.length-1][grid.length-1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>(); 
        int step = 1;
        queue.offer(new int[]{0,0}); 
        while(!queue.isEmpty()) { 
            int n = queue.size(); 
             
            while(n > 0) { 
                int[] curr = queue.poll(); 
                int row = curr[0]; 
                int col = curr[1]; 
                // reached reach first = shortest
                if (row == grid.length-1 && col == grid.length-1) { 
                    return step; 
                } 
                // go up
                if(row > 0 && grid[row-1][col] ==0) { 
                    queue.offer(new int[]{row-1, col}); 
                    grid[row-1][col] = 1; 
                }

                // go down 
                if(row < grid.length-1 && grid[row+1][col] ==0) { 
                    queue.offer(new int[]{row+1, col}); 
                    grid[row+1][col] = 1; 
                }

                // go right 
                if(col < grid.length-1 && grid[row][col+1] ==0) { 
                    queue.offer(new int[]{row, col+1}); 
                    grid[row][col+1] = 1; 
                }

                // go left 
                if(col > 0 && grid[row][col-1] ==0) { 
                    queue.offer(new int[]{row, col-1}); 
                    grid[row][col-1] = 1; 
                }
                // go  up right
                if(row > 0 &&  col < grid.length-1 && grid[row-1][col+1] == 0) { 
                    queue.offer(new int[]{row-1, col+1});
                    grid[row-1][col+1] = 1; 
                }

                // go up left
                if(row > 0 &&  col > 0 && grid[row-1][col-1] == 0) { 
                    queue.offer(new int[]{row-1, col-1});
                    grid[row-1][col-1] = 1; 
                }

                // go down right 
                if(row < grid.length-1 &&  col < grid.length-1 && grid[row+1][col+1] == 0) { 
                    queue.offer(new int[]{row+1, col+1});
                    grid[row+1][col+1] = 1; 
                }

                // go down left
                if(row < grid.length-1 &&  col > 0 && grid[row+1][col-1] == 0) { 
                    queue.offer(new int[]{row+1, col-1});
                    grid[row+1][col-1] = 1; 
                }
                 n--; 
            }
            step = step + 1; 
        }
        return -1;
    }
}