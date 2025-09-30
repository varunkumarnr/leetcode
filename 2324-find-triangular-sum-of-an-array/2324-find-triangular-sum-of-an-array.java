class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length; 
        if(nums.length == 1) { 
            return nums[0]; 
        }
        List<Integer> list = new ArrayList<>();  
        for(int i = 0; i< nums.length; i++) { 
            list.add(nums[i]); 
        }
        for(int i = 1 ; i< n;i++) { 
            int curr = 0;
            while(curr <  n - i) { 
                list.set(curr, (list.get(curr) + list.get(curr + 1)) % 10);
                curr++;
            };
        }
        return list.get(0);
    }
}