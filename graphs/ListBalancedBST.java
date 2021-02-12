/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode a) {
        return recursiveTree(a, null);
    }
    
    
    TreeNode recursiveTree(ListNode left, ListNode right){
        if(left == right) return null;
        
        ListNode mid = getMid(left, right);
        
        TreeNode root = new TreeNode(mid.val);
        root.left = recursiveTree(left, mid);
        root.right = recursiveTree(mid.next, right);
        
        return root;
        
    }
    ListNode getMid(ListNode left, ListNode right){
        if(left == null) return null;
        ListNode mid=left, fast=left;
        
        while(fast.next != right && fast.next.next != right){
            fast = fast.next.next;
            mid = mid.next;
        }
        return mid;
    }
}
