class Solution {
    public int triangleNumber(int[] nums) {
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