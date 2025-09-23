class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = Arrays.stream(piles).max().getAsInt(); 
        while(left < right) { 
            int mid = (left + right) / 2; 
            if(is_possible(piles, mid, h)) {
                right = mid;  
            } else{ 
                left = mid + 1; 
            }
        }
        return left; 
    }

    boolean is_possible(int[] piles , int mid, int h) { 
        int H = 0; 
        for(int pile : piles) { 
            H += (int) Math.ceil((double)pile/mid);
        }
        return H <= h; 
    }
}