class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0; 
        for(int i = 0; i<points.length; i++) {
            for(int j =0; j<points.length; j++) {
                if(i ==j) continue;
                int[] first = points[i];
                int[] second = points[j];
                if(first[0] >= second[0] && first[1] <= second[1]) {
                    boolean blocked = false; 
                    for(int k = 0; k< points.length; k++) {
                        if( k == i || k == j) continue; 
                        if (first[0] >= points[k][0] && points[k][0] >= second[0]
                            && first[1] <= points[k][1] && points[k][1] <= second[1]) {
                                blocked = true; 
                                break;
                        }                       
                    }
                    if(!blocked) count++; 
                }
            }
        }
        return count; 
    }
}