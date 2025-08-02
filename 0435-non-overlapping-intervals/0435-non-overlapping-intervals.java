class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]); 
        int prevEnd = Integer.MIN_VALUE;
        int count = 0;  
        for(int[] interval : intervals) {
            if(interval[0] < prevEnd) {
                count++;
                continue; 
            } 
            prevEnd= interval[1]; 
        }
        return count; 
    }
}