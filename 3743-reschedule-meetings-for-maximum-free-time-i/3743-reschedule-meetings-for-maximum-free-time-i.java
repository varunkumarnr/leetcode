class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] freeTime = new int[startTime.length+1];
        if(startTime.length > 0) {
            freeTime[0] = startTime[0]; 
        }
        for(int i = 1; i < startTime.length; i++) { 
             freeTime[i] = startTime[i] - endTime[i-1]; 
        } 
        freeTime[startTime.length] = eventTime - endTime[endTime.length-1];
        // System.out.println(Arrays.toString(freeTime));
        // [1,1,0] // [0,1,5,0]
        int s = 0, e = 0, maxBreak  = 0; 
        int currentWindowSum = 0;
        while(e<freeTime.length) {  
            while(e-s <= k) {
                currentWindowSum += freeTime[e];
                e++;
            }
            maxBreak = Math.max(maxBreak, currentWindowSum);
            currentWindowSum -= freeTime[s];
            s++; 
        }
        return maxBreak;
    }
}