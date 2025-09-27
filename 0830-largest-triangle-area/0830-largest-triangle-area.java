class Solution {
    public double largestTriangleArea(int[][] points) {
        /* 
            Area = (1/2) * |x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)|
        */

        int n = points.length; 
        double maxArea = 0; 
        for(int i = 0; i<n;i++) { 
            for(int j = 0; j<n; j++) { 
                for(int k = 0; k<n;k++) { 
                    double currArea = (0.5) * Math.abs(((points[i][0]) * (points[j][1] - points[k][1])) + (points[j][0] * (points[k][1] - points[i][1])) + (points[k][0] * (points[i][1] - points[j][1]))); 
                    maxArea = Math.max(maxArea , currArea); 
                }
            }
        }
        return maxArea; 
    }
}