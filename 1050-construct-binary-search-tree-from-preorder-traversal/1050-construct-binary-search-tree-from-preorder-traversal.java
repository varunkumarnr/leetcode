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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length  == 0) return new TreeNode();
        TreeNode root = new TreeNode(preorder[0]); 
        for(int i = 1; i < preorder.length; i++) {
            dfs(root, preorder[i]); 
        }
        return root; 
    }
    TreeNode dfs(TreeNode root, int num) {
        if(root == null) {
            return new TreeNode(num);
        }
        if(num < root.val) {
          root.left = dfs(root.left, num); 
        } else { 
            root.right = dfs(root.right, num);
        }
        return root;
    }
}