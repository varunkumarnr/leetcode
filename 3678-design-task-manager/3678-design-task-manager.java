class TaskManager {
    /* 
        user priority queue Map of tasks and priority array. 
        taskid priority list Mapping --> identify updated stats and help in soft delete. 
    */
    HashMap<Integer, Integer> taskIdMap; 
    PriorityQueue<int[]> heap; 
    HashMap<Integer, Integer> taskUserMap; 
    public TaskManager(List<List<Integer>> tasks) {
        heap = new PriorityQueue<>((a,b) -> {
            if(a[2] == b[2]) return b[1] - a[1]; 
            else return b[2] - a[2]; 
        });
        taskIdMap = new HashMap<>();
        taskUserMap = new HashMap<>();
        for(List<Integer> task : tasks)  {
            int user = task.get(0); 
            int taskId = task.get(1);
            int priority = task.get(2);
            taskIdMap.put(taskId, priority); 
            heap.offer(new int[]{user, taskId, priority}); 
            taskUserMap.put(taskId, user); 
        }
    }
    
    public void add(int userId, int taskId, int priority) {
            taskIdMap.put(taskId, priority); 
            heap.offer(new int[]{userId, taskId, priority}); 
            taskUserMap.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        int user = taskUserMap.get(taskId); 
        heap.offer(new int[]{user, taskId, newPriority}); 
        taskIdMap.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        taskUserMap.remove(taskId); 
        taskIdMap.remove(taskId); 
    }
    
    public int execTop() {
    while (!heap.isEmpty()) { 
        if (!heap.isEmpty() && !taskIdMap.containsKey(heap.peek()[1])) {
            heap.poll(); 
            continue; 
        }
        while (!heap.isEmpty()) {
            int taskId = heap.peek()[1];
            if (!taskIdMap.containsKey(taskId)) {
                heap.poll(); 
                continue;
            }
            if (heap.peek()[2] != taskIdMap.get(taskId)) {
                heap.poll(); 
                continue;
            }
            break; 
        }
        if (heap.isEmpty()) return -1; 

        int[] top = heap.poll();
        int taskId = top[1];
        int user = taskUserMap.get(taskId);

        taskIdMap.remove(taskId);
        taskUserMap.remove(taskId);
        return user;

    }
    return -1;
}


}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */