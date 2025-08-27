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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null; 
        Queue<TreeNode> queue = new LinkedList<>(); 
        TreeNode result = root; 
        queue.offer(root); 
        while(!queue.isEmpty()) {
            int n = queue.size(); 
            while(n > 0) {
                TreeNode curr = queue.poll(); 
                TreeNode temp = curr.right; 
                curr.right = curr.left; 
                curr.left = temp; 
                if(curr.left!= null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                n--; 
            }
        }
        return result; 
    }
}