class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int at_x  = 0; 
        int at_y  = 0; 
        int dir = 0; 
        List<Integer> list = new ArrayList<>(); 
        
        int total = matrix.length * matrix[0].length;

        while (list.size() < total) {

            boolean moved = false;

            if (matrix[at_x][at_y] == Integer.MAX_VALUE) {
                if (dir == 0) at_y++;
                else if (dir == 1) at_y--;
                else if (dir == 2) at_x--;
                else if (dir == 3) at_x++;
            }

            if (dir == 0) {  // right
                while (at_y < matrix[0].length && matrix[at_x][at_y] != Integer.MAX_VALUE) {
                    list.add(matrix[at_x][at_y]);
                    matrix[at_x][at_y] = Integer.MAX_VALUE;
                    moved = true;

                    if (at_y + 1 < matrix[0].length && matrix[at_x][at_y + 1] != Integer.MAX_VALUE) {
                        at_y++;
                    } else break;
                }
                dir = 3;

            } else if (dir == 3) {  // down
                while (at_x < matrix.length && matrix[at_x][at_y] != Integer.MAX_VALUE) {
                    list.add(matrix[at_x][at_y]);
                    matrix[at_x][at_y] = Integer.MAX_VALUE;
                    moved = true;

                    if (at_x + 1 < matrix.length && matrix[at_x + 1][at_y] != Integer.MAX_VALUE) {
                        at_x++;
                    } else break;
                }
                dir = 1;

            } else if (dir == 1) {  // left
                while (at_y >= 0 && matrix[at_x][at_y] != Integer.MAX_VALUE) {
                    list.add(matrix[at_x][at_y]);
                    matrix[at_x][at_y] = Integer.MAX_VALUE;
                    moved = true;

                    if (at_y - 1 >= 0 && matrix[at_x][at_y - 1] != Integer.MAX_VALUE) {
                        at_y--;
                    } else break;
                }
                dir = 2;

            } else if (dir == 2) {  // up
                while (at_x >= 0 && matrix[at_x][at_y] != Integer.MAX_VALUE) {
                    list.add(matrix[at_x][at_y]);
                    matrix[at_x][at_y] = Integer.MAX_VALUE;
                    moved = true;

                    if (at_x - 1 >= 0 && matrix[at_x - 1][at_y] != Integer.MAX_VALUE) {
                        at_x--;
                    } else break;
                }
                dir = 0;
            }

            if (!moved) break;
        }

        return list;
    }
}