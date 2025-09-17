class FoodRatings {
    HashMap<String, PriorityQueue<Object[]>> countryFood = new HashMap<>(); 
    HashMap<String, String> foodCuisine = new HashMap<>();  
    HashMap<String, Integer> foodRating = new HashMap<>(); 
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i< foods.length; i++) { 
           if (!countryFood.containsKey(cuisines[i])) {
            countryFood.put(cuisines[i], new PriorityQueue<>((a, b) -> {
                int ratingA = (int) a[1];
                int ratingB = (int) b[1];
                String foodA = (String) a[0];
                String foodB = (String) b[0];
                if (ratingA == ratingB) {
                    return foodA.compareTo(foodB);  
                }
                return ratingB - ratingA; 
            }));
        }
            countryFood.get(cuisines[i]).offer(new Object[]{foods[i], ratings[i]}); 
            foodCuisine.put(foods[i], cuisines[i]); 
            foodRating.put(foods[i], ratings[i]); 
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        countryFood.get(cuisine).offer(new Object[]{food, newRating}); 
        foodRating.put(food, newRating); 
        // PriorityQueue<Object[]> heap   = countryFood.get(cuisine); 
        // while(!heap.isEmpty() && !heap.peek()[0].equals(food)) {
        //     temp.add(heap.poll()); 
        // }
        // if(heap.peek()[0].equals(food)) {
        //     heap.poll(); 
        //     heap.offer(new Object[]{food, newRating}); 
        // }
        // for(Object[] all : temp) {
        //     heap.offer(all); 
        // }
    }
    public String highestRated(String cuisine) {
        PriorityQueue<Object[]>  heap = countryFood.get(cuisine); 
        while(true) {
            Object[] curr = heap.peek();
            if((int) curr[1] == foodRating.get(curr[0])) {
                return (String) curr[0]; 
            }
            heap.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */