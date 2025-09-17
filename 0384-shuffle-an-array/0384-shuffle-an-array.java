import java.util.Random;

class Solution {
    int[] input, original;
    Random rand = new Random();

    public Solution(int[] nums) {
        input = nums.clone();
        original = nums.clone();
    }
    
    public int[] reset() {
        input = original.clone();
        return input; 
    }
    
    public int[] shuffle() {
        for (int i = input.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        return input;
    }
}
