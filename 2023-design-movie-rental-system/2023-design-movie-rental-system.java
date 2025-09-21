class MovieRentingSystem {
    Map<Integer, PriorityQueue<int[]>> search; 
    TreeSet<int[]> report; 
    Map<String, Integer> history; 
    Map<String, Integer> activeState;  
    public MovieRentingSystem(int n, int[][] entries) {
        search = new HashMap<>(); 
        report = new TreeSet<>((a,b) -> {
            if(a[0] == b[0] && a[2] == b[2]) { 
                return a[1] - b[1]; 
            } else if(a[2] == b[2]) { 
                return a[0] - b[0];
            } else { 
                return a[2] - b[2]; 
            }
        }); 
        history = new HashMap<>();
        activeState = new HashMap<>(); 
        for(int[] entry: entries) { 
            int shop = entry[0]; 
            int movie = entry[1]; 
            int price = entry[2]; 
            if(!search.containsKey(movie)) {
                search.put(movie, new PriorityQueue<>((a,b) -> {
                    if(a[1] == b[1]) { 
                        return a[0] - b[0]; 
                    } else { 
                        return a[1] - b[1]; 
                    }
                }));
            }
            search.get(movie).offer(new int[]{shop, price}); 
            String key = String.valueOf(shop) + '-' + String.valueOf(movie); 
            history.put(key, price); 
            activeState.put(key, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if(!search.containsKey(movie)) { 
            return result;
        }
        PriorityQueue<int[]> currMovie = search.get(movie); 
        List<int[]> temp = new ArrayList<>(); 
        int size = 0; 
        while(size < 5 && !currMovie.isEmpty()) {
            int[] curr = currMovie.poll(); 
            temp.add(curr);
            String key = String.valueOf(curr[0]) + '-' + String.valueOf(movie); 
            if(activeState.containsKey(key) && activeState.get(key) == curr[1]) { 
                result.add(curr[0]); 
                 size++;
            }
        }
        for(int[] ob : temp) { 
            currMovie.offer(ob); 
        }
        return result; 
    }
    
    public void rent(int shop, int movie) {
        String key = String.valueOf(shop) + '-' + String.valueOf(movie); 
        activeState.remove(key); 
        report.add(new int[] {shop, movie, history.get(key)}); 
    }
    
    public void drop(int shop, int movie) {
        String key = String.valueOf(shop) + '-' + String.valueOf(movie); 
        activeState.put(key, history.get(key));
        report.remove(new int[]{shop, movie, history.get(key)});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>(); 
        List<int[]> taken = new ArrayList<>();
        int count = 0;
        while (!report.isEmpty() && count < 5) {
            int[] curr = report.pollFirst(); 
            taken.add(curr); 
            result.add(Arrays.asList(curr[0], curr[1]));
            count++;
        }
        for (int[] arr : taken) {
            report.add(arr);
        }

        return result; 
    }
}
/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */