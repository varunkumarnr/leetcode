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
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         Queue<TreeNode> queueP = new LinkedList<>(); 
//         Queue<TreeNode> queueQ = new LinkedList<>(); 
//         if(p == null && q != null) return false; 
//         if(q == null && p!= null) return false;
//         if(p== null && q==null) return true;
//         queueP.offer(p); 
//         queueQ.offer(q); 
//         while(!queueP.isEmpty() || !queueQ.isEmpty()) {
//             int n = queueP.size(); 
//             while(n>0) {
//             TreeNode currP = queueP.poll();
//             TreeNode currQ = queueQ.poll();
//             if(currP.val != currQ.val) return false;
//             if(currP.left != null) queueP.offer(currP.left); 
//             if(currQ.left != null) queueQ.offer(currQ.left); 
//             if(queueP.size() != queueQ.size()) {
//                 return false;
//             }
//             if(currP.right != null) queueP.offer(currP.right); 
//             if(currQ.right != null) queueQ.offer(currQ.right);
//             n--;
//             if(queueP.size() != queueQ.size()) {
//                 return false;
//             }
//             } 
//         }
//         return true; 
//     }
// }


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q); 
    }

    boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; 
         if (p == null || q == null) return false;
        if(p.val != q.val) return false; 
        boolean left = dfs(p.left, q.left); 
        if(left == false) return false;
        boolean right = dfs(p.right, q.right);
        if(right == false) return false;         
        return left && right; 
    }
}