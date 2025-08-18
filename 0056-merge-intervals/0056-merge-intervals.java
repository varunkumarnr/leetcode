class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        if(intervals.length <= 1) return intervals; 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 0; i<intervals.length-1; i++) {
            int[] curr = intervals[i]; 
            int start = curr[0];
            int end = curr[1]; 
            while(i<intervals.length-1 && curr[1] >= intervals[i+1][0]) {
                if(end < intervals[i+1][1]) {
                    curr = intervals[i+1]; 
                    end = intervals[i+1][1]; 
                }
                i++; 
            }
            merged.add(new int[]{start, end});
        }
        // add last element
        if(merged.get(merged.size()-1)[1] != intervals[intervals.length-1][1]) {
            if(merged.get(merged.size()-1)[1] >= intervals[intervals.length-1][0]) {
                int[] temp = merged.get(merged.size()-1);
                int start = temp[0];
                int end = temp[1];
                if(end < intervals[intervals.length-1][1]) {
                    merged.remove(merged.size()-1); 
                    merged.add(new int[]{start, intervals[intervals.length-1][1]});
                }
            } else {
                merged.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
            }
        }

        int[][] result = new int[merged.size()][2];
        for(int i=0; i<merged.size();i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}