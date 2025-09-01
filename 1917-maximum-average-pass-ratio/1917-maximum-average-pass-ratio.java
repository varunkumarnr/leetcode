class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            double x = gain(a[0], a[1]); 
            double y = gain(b[0], b[1]);
            return Double.compare(y,x);
        });

        for(int[] c : classes) {
            maxHeap.offer(c); 
        }

        while(extraStudents > 0) {
            int[] top = maxHeap.poll();
            top[0] = top[0] + 1; 
            top[1] = top[1] + 1; 
            maxHeap.offer(top);   
            extraStudents--;
        }

        double sum = 0; 
        for(int i = 0; i< classes.length; i++) {
            int curr[] = maxHeap.poll(); 
            sum += (double) curr[0]/curr[1]; 
        }
        return sum/classes.length; 

    }

    double gain(int a, int b) {
        return ((double)(a + 1) / (b + 1)) - ((double)a / b);
    }
}