// class TreeNode { 
//     int val; 
//     TreeNode left; 
//     TreeNode right; 
//     TreeNode(){}; 
//     TreeNode(int val) {
//         this.val = val; 
//     }
//     TreeNode(int val, TreeNode left, TreeNode right) { 
//         this.val = val; 
//         this.left = left; 
//         this.right = right; 
//     }
// }
class Solution {
    int sum=0; 
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0; 
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        int sum = 0; 
        while(queue.size() > 0) { 
            int n = queue.size(); 
            while(n > 0) {
                TreeNode curr = queue.poll();
                 if(low <= curr.val && high >= curr.val) {
                    sum += curr.val; 
                 }
                 if(curr.left != null) queue.offer(curr.left); 
                 if(curr.right != null) queue.offer(curr.right); 
                 n--; 
            }
        }   
        return sum; 
    }
}