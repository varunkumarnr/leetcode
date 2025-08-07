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
    public boolean isBalanced(TreeNode root) {
        return dfs(root,0) == -1 ? false : true ;
    }
    int dfs(TreeNode root, int height){
        if(root == null) return 0; 
        int leftHeight = dfs(root.left, height); 
        if(leftHeight ==-1) return -1;
        int rightHeight= dfs(root.right, height); 
        if(rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1; 
        return 1+ Math.max(leftHeight, rightHeight);
    }
}