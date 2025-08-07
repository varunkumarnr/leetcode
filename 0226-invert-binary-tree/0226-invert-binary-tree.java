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
        Queue<TreeNode> s  = new LinkedList<>();
        s.offer(root);
        while(!s.isEmpty()) {
            int n = s.size(); 
            while(n > 0) {
                TreeNode node = s.poll(); 
                n--; 
                TreeNode temp = node.left;  
                node.left = node.right; 
                node.right = temp; 
                if(node.left != null) s.offer(node.left);
                if(node.right != null) s.offer(node.right);
            }
        }
        return root; 
    }
}