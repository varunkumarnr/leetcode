class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> results = new ArrayList<>();
        int[] temp = new int[]{-1,-1}; 
        for(int[] interval : intervals) {
            if(temp[1] != -1 && temp[1] < interval[0]) 
            {
                results.add(new int[]{temp[0], temp[1]});
                temp[0] = -1;
                temp[1] = -1; 
            }; 
            temp[1] = Math.max(temp[1], interval[1]);    
            if(temp[0] == -1) temp[0] = interval[0]; 
        }
        if(temp[0] != -1 && temp[1] !=-1) {
            results.add(temp); 
        } 
        int[][] res = new int[results.size()][2];
        for(int i= 0; i<results.size(); i++){
            res[i] = results.get(i); 
        }
        return res; 
    }
}