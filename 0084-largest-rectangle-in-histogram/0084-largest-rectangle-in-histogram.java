class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>(); 
    int maxArea = 0;
    int n = heights.length;
    for (int i = 0; i <= n; i++) {
        int h = (i == n) ? 0 : heights[i];
        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }
    return maxArea;
    }
}


//////

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int minIndex = 0;
//         int minValue = Integer.MAX_VALUE;
//         for(int i = 0; i< heights.length; i++) {
//             if(heights[i] < minValue) {
//                 minValue= heights[i]; 
//                 minIndex = i;
//             }
//         }
//         int areaOfMinIndex = minValue * heights.length; 
//         int maxAreaLeft = 0;
//         for(int i = minIndex-1; i>=0; i--) {
//             int n = i; 
//             int currLeftMinElement = Integer.MAX_VALUE;
//             int leftLengthCurr = 1;
//             while(n>=0) {
//                 currLeftMinElement  = Math.min(currLeftMinElement, heights[n]); 
//                 maxAreaLeft = Math.max(maxAreaLeft, currLeftMinElement * leftLengthCurr); 
//                 n--; 
//                 leftLengthCurr++;
//             }
//         }

//         // area to right
//         int maxAreaRight = 0;
//         // area to left 
//         for(int i = minIndex +1 ; i<heights.length; i++) {
//             int n = i; 
//             int currRightMinElement = Integer.MAX_VALUE;
//             int rightLengthCurr = 1;
//             while(n<heights.length) {
//                 currRightMinElement  = Math.min(currRightMinElement, heights[n]); 
//                 maxAreaRight = Math.max(maxAreaRight, currRightMinElement * rightLengthCurr); 
//                 n++; 
//                 rightLengthCurr++;
//             }
//         }

//         return Math.max(areaOfMinIndex, Math.max(maxAreaLeft, maxAreaRight));
//     }
// }