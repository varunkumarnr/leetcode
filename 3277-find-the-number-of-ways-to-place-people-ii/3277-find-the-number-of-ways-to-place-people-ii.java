class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        int count = 0; 
        for(int i = 0; i<points.length; i++) {
            for(int j =i+1; j<points.length; j++) {                
                int[] first = points[i];
                int[] second = points[j];
                if(first[0] >= second[0] && first[1] <= second[1]) {
                    boolean blocked = false; 
                    for(int k = i+1; k< j; k++) {
                        // if( k == i || k == j) continue; 
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