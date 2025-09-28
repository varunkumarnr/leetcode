class Solution {
    public int largestPerimeter(int[] nums) {
        int ans = 0;
        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) ->  b - a);
        for(int i = 0; i<boxed.length-2;i++) { 
            if(boxed[i] < boxed[i+1] + boxed[i+2]) { 
                int currAns = boxed[i] + boxed[i+1] + boxed[i+2];
                ans = Math.max(currAns, ans);  
            }
        }
        return ans; 
    }
}