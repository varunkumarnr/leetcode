// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         if(root == null) return false; 
//         Set<Integer> set = new HashSet<>(); 
//         Queue<TreeNode> queue = new LinkedList<>(); 
//         queue.offer(root); 
//         set.add(root.val);
//         while(!queue.isEmpty()) {
//             int n = queue.size(); 
//             while(n > 0) {
//                 TreeNode curr = queue.poll(); 
//                 if(curr.left != null) {
//                     TreeNode left = curr.left; 
//                     if(set.contains(k-left.val)) {
//                         return true; 
//                     }
//                     queue.offer(left);
//                     set.add(left.val);
//                 }
//                 if(curr.right != null) {
//                     TreeNode right = curr.right; 
//                     if(set.contains(k - right.val)) {
//                         return true; 
//                     }
//                     queue.offer(right);
//                     set.add(right.val); 
//                 }
//                 n--;
//             }
//         }
//         return false; 
//     }
// }

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) return false;
        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}