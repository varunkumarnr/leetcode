class Solution {
    public int islandPerimeter(int[][] grid) {
        Set<List<Integer>> island = new HashSet<>(); 

        for(int i =0; i<grid.length; i++) { 
            for(int j = 0; j< grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    island.add(Arrays.asList(i,j));
                }
            }
        }

        int totalPeremeter = island.size() * 4; 

        for(List<Integer> s: island) { 
            int r = s.get(0);
            int c = s.get(1); 
            System.out.println(r + " " + c);
            // checkleft 
            if(island.contains(Arrays.asList(r-1, c))) {
                totalPeremeter -=1;
            }
            if(island.contains(Arrays.asList(r+1, c))) {
                totalPeremeter -=1;
            }
            if(island.contains(Arrays.asList(r, c-1))) {
                totalPeremeter -=1;
            }
            if(island.contains(Arrays.asList(r, c+1))) {
                totalPeremeter -=1;
            }
        }
        return totalPeremeter;
    }
}