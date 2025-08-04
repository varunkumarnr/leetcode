class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0]; 
        int bestProfit = 0;  
        for (int i =1; i<prices.length; i++) {
            bestProfit = Math.max(bestProfit, prices[i] - minPrice); 
            minPrice = Math.min(minPrice , prices[i]);
        }
        return bestProfit; 
     }
}