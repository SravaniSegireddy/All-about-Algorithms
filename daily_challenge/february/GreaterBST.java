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
    public TreeNode convertBST(TreeNode root) {
        reverseOrder(root,0);
        return root;
    }
    
    int reverseOrder(TreeNode root, int prev){
        if(root == null) return 0;
        
        int tmp = root.val;
        int right = reverseOrder(root.right,prev);
        root.val += right+prev;
        int left = reverseOrder(root.left, root.val);
        return left+tmp+right;
    }
}
