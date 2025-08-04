class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0; 
        int maxCount = Integer.MIN_VALUE; 
        while(right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2) {
                map.put(fruits[left], map.getOrDefault(fruits[left],0)-1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            System.out.println(right + " " + left);
            maxCount = Math.max(maxCount , (right- left)+1);  
            right++;
        }
        return maxCount;
    }
}