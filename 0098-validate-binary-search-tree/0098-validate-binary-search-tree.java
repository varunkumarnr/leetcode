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
    public boolean isValidBST(TreeNode root) {
        List<Integer> store = new ArrayList<>(); 
        dfs(root, store); 
        for(int i = 1; i<store.size(); i++) {
            if(store.get(i-1) >= store.get(i)) {
                return false;
            }
        }
        return true;
    }
    void dfs(TreeNode root, List<Integer> curr) {
        if(root == null) return; 
        dfs(root.left, curr); 
        curr.add(root.val); 
        dfs(root.right, curr);
    }
}