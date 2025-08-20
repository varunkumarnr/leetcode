class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> set = new HashSet<>(); 
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) { 
                if(matrix[i][j] == 0) {
                    set.add(i);
                    set2.add(j);
                }
            }
        }
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(set.contains(i) || set2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}