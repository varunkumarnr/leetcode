class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for(int i =0; i<m;i++) {
            temp[i] = nums1[i];
        }  
        int first = 0;
        int second = 0; 
        int i = 0; 
        while(first < m && second<n) {
            if(temp[first] <= nums2[second]) {
                nums1[i] = temp[first]; 
                first++; 
                i++; 
            } else {
                nums1[i] = nums2[second];
                second++; 
                i++; 
            }
        }
        while(first < m) { 
            nums1[i] = temp[first]; 
            first++; 
            i++; 
        }
        while(second < n) {
            nums1[i] = nums2[second];
            second++; 
            i++; 
        }
    }
}