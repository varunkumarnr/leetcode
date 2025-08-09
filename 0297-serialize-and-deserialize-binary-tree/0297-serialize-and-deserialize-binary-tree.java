/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index = 0;


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder(); 
        int n = 0;
        dfs(root, s,n);
        return s.toString();
    }

    void dfs(TreeNode root, StringBuilder s, int n) {
        if(root == null && n ==0) {
            s.append("null");
            return;
        } else if(root == null && n !=0) { 
            s.append(",null");
            return;
        }
        if(n==0 && root !=null) {
            s.append(root.val);
            n++;
        } else{
            s.append(","+root.val);
            n++;
        }
        dfs(root.left,s , n); 
        dfs(root.right, s,n); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        int index = 0;
        return build(str); 
    }

    public TreeNode build(String[] str) {
        if(index >= str.length || "null".equals(str[index])
) {
            index++;
            return null; 
        }
        TreeNode node = new TreeNode(Integer.parseInt(str[index]));
        index++;
        node.left = build(str); 
        node.right = build(str); 
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));