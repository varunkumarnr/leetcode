class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        int n = nums.length;
        Arrays.sort(nums); 
        for(int i =0; i<nums.length -2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue; 
            int l = i+1; 
            int r = n-1; 
            while(l < r) {
                int curr = nums[i] + nums[l] +nums[r];
                if(curr == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l] == nums[l+1]) {
                        l++; 
                    }
                    while(l<r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if(curr > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result; 
    }
}