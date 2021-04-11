class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            int sum = 0;
            while(size-- > 0){
                TreeNode curr = q.remove();
                if(curr.left == null && curr.right == null) sum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(sum != 0){
                res = sum;
            }
        }
        
        return res;
    }
}
