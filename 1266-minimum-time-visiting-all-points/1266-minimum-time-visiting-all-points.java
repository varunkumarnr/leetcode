class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // if(points.length < 2) return 0; 
        // int curr_x = points[0][0]; 
        // int curr_y = points[0][1]; 
        // int total_steps = 0; 
        // for(int[] point : points) { 
        //     int x = point[0]; 
        //     int y = point[1]; 
        //     // if(curr_x == x && curr_y == y) continue; 
        //     while(curr_x != x || curr_y != y) { 
        //         // move diagonally as much as possible 
        //         // chose which diagonal 
        //         if(curr_x == x) {
        //             if(curr_y < y) { 
        //                 curr_y +=1; 
        //                 total_steps +=1; 
        //             } else { 
        //                 curr_y -= 1; 
        //                 total_steps +=1; 
        //             }
        //         } // only move up or down
        //         else if(curr_y == y) {
        //             if(curr_x < x) { 
        //                 curr_x +=1; 
        //                 total_steps +=1; 
        //             } else { 
        //                 curr_x -= 1; 
        //                 total_steps +=1; 
        //             }
        //         } // only move left or right
        //         else if(curr_x > x && curr_y > y) { // move bottom left
        //             curr_x--; 
        //             curr_y--; 
        //             total_steps +=1; 
        //         } else if ( curr_x  < x && curr_y >y) // move bottom right
        //             {
        //                 curr_x++; 
        //                 curr_y--; 
        //                 total_steps++; 
        //         }  else if (curr_x < x && curr_y <y) {  // top right
        //             curr_x++; 
        //             curr_y++; 
        //             total_steps++; 
        //          }    else    if( curr_x > x && curr_y < y) // top left
        //          { 
        //             curr_x--;
        //             curr_y++; 
        //             total_steps++; 
        //          }      
        //         }
        // }
        // return total_steps; 
        int total_steps = 0; 
        for(int i = 0; i<points.length-1; i++) { 
            int x_diff  = Math.abs(points[i][0] - points[i+1][0]);  
            int y_diff  = Math.abs(points[i][1] - points[i+1][1]); 
             total_steps += Math.max(x_diff, y_diff); 
        }
        return total_steps;
    }
}