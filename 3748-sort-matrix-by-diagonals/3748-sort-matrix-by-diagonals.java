class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++)
            System.arraycopy(grid[i], 0, result[i], 0, n);

        for (int colStart = 1; colStart < n; colStart++) {
            int row = 0, col = colStart;
            List<Integer> diagonal = new ArrayList<>();
            while (row < n && col < n) {
                diagonal.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(diagonal); 
            row = 0; col = colStart;
            for (int val : diagonal) {
                result[row][col] = val;
                row++; col++;
            }
        }

        for (int rowStart = 0; rowStart < n; rowStart++) {
            int row = rowStart, col = 0;
            List<Integer> diagonal = new ArrayList<>();
            while (row < n && col < n) {
                diagonal.add(grid[row][col]);
                row++;
                col++;
            }
            diagonal.sort((a,b) -> b - a); 
            row = rowStart; col = 0;
            for (int val : diagonal) {
                result[row][col] = val;
                row++; col++;
            }
        }

        return result;
    }
}
