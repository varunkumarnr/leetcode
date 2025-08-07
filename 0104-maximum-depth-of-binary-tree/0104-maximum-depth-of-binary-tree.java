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
    public int maxDepth(TreeNode root) {
        int maxHeight = dfs(root); 
        return maxHeight;
    }
    int dfs(TreeNode root) {
        if(root == null) return 0; 
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right); 
        return 1 + Math.max(leftHeight, rightHeight); 
    } 
}