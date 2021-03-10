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
    int depth;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return null;
        depth = d;
        return dfs(root, 1, v, true);
    }
    
    TreeNode dfs(TreeNode root, int d, int v, boolean isLeft){
        if(d == depth){
            TreeNode tmp = new TreeNode(v);
            if(isLeft) tmp.left = root;
            else tmp.right = root;
            return tmp;
        }
        
        if(root.left!= null) root.left = dfs(root.left, d+1, v, true);
        else if(d == depth-1) root.left = new TreeNode(v);
        
        if(root.right!= null) root.right = dfs(root.right, d+1, v, false);
        else if(d == depth-1) root.right = new TreeNode(v);
        
        
        return root;
    }
}
