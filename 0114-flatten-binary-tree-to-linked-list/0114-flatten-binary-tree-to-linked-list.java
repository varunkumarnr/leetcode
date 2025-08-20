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

 /* [3, 4, 2, 6, 5, 1]  */
class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}
