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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>(); 
        if(root == null) return result;
        queue.offer(root); 
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> curr = new ArrayList<>(); 
            while(n > 0) {
                TreeNode node = queue.poll();
                curr.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                n--;
            }
                result.add(curr); 
            
        }
        return result;
    }
}