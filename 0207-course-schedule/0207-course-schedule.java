class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     Map<Integer, List<Integer>> map = new HashMap<>();
     for(int i =0; i<numCourses;i++) {
        map.put(i, new ArrayList<>());
     }
     int[] state = new int[numCourses];
     for(int i = 0;i<prerequisites.length;i++) {
        int from = prerequisites[i][0];
        int to = prerequisites[i][1];
        map.computeIfAbsent(from, v -> new ArrayList<>()).add(to); 
     }   
     for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
        if(state[entry.getKey()] == 0 && dfs(entry.getKey(), state, map)) return false;
     }
     return true; 
    }
    public boolean dfs(int node, int[] state,Map<Integer, List<Integer>> map) {
        state[node] =1;
        for(int neib : map.get(node)) {
            if(state[neib] == 1) return true; 
            if(state[neib] ==0 && dfs(neib, state, map)) return true; 
        }
        state[node] =2;
        return false;  
    }
}