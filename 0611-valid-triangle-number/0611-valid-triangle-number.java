class Solution {
    public int triangleNumber(int[] nums) {

        /* 
            2  2 3 4   2 + 3 > 4
            i    j  k    result = j- i
            if wil be grater then obviously 1th element will be greater instead of recomuting just add. 
        */
        int result = 0; 
        Arrays.sort(nums); 
        for (int i = nums.length - 1; i >= 2; i--) { 
            int start = 0; 
            int end = i - 1; 
            while (start < end) { 
                if (nums[start] + nums[end] > nums[i]) { 
                    result += (end - start); 
                    end--; 
                } else { 
                    start++; 
                }
            }
        }
        return result; 
    }
}