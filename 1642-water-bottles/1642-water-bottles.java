class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int remaining = numBottles; 
        while(remaining >= numExchange) { 
            int newBottles = remaining / numExchange; 
            numBottles += newBottles; 
            remaining = newBottles + (remaining % numExchange); 
        }
        return numBottles; 
    }
}