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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; 
        return dfs(root, key); 
    }
    TreeNode dfs(TreeNode node, int key) {
         if(node == null) return null; 
         if(node.val < key) { 
            node.right = dfs(node.right, key);
         } else if(node.val > key) { 
            node.left  = dfs(node.left, key);
         } else if(node.val == key) { 
            if(node.left == null && node.right == null) return null;
            if(node.left == null && node.right != null) return node.right; 
            if(node.right == null && node.left != null) return node.left; 
            else { 
                TreeNode successor = findMin(node.right);
                node.val = successor.val;
                node.right = deleteNode(node.right, successor.val);
            }
         }
         return node;
    }
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}