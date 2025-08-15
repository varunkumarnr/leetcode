/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Object[]> queue = new LinkedList<>(); 
        if(root == null) return result; 
        queue.add(new Object[]{root, 0, 0});
        while(!queue.isEmpty()) {
            int n = queue.size(); 
            while(n > 0) {
                Object[] curr = queue.poll();
                TreeNode node = (TreeNode) curr[0];
                int x = (int) curr[1];
                int y = (int) curr[2];

                map.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{y, node.val});
                if(node.left != null) {
                    queue.offer(new Object[]{node.left, x-1, y+1});
                }
                if(node.right != null) {
                   queue.offer(new Object[]{node.right, x+1, y+1});
                }
                n--;
            }
        }
        for(List<int[]> list : map.values()){
            list.sort((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
            List<Integer> temp = new ArrayList<>();
            for(int[] p : list) temp.add(p[1]);
            result.add(temp);
        }
        return result; 
    }
}