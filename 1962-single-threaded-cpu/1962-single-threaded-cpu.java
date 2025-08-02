class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] updatedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            updatedTasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(updatedTasks, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        PriorityQueue<int[]> availableTasks = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]
        );

        List<Integer> order = new ArrayList<>();
        int time = 0, index = 0;

        while (index < n || !availableTasks.isEmpty()) {
            while (index < n && updatedTasks[index][0] <= time) {
                availableTasks.offer(updatedTasks[index++]);
            }
            if (!availableTasks.isEmpty()) {
                int[] current = availableTasks.poll();
                order.add(current[2]);       
                time += current[1];         
            } else {
                time = updatedTasks[index][0];
            }
        }

        return order.stream().mapToInt(Integer::intValue).toArray();
    }
}
