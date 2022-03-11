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

	//recursive
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left != null && right != null && left.val == right.val) {
            return isMirror(left.left, right.right) && 
                isMirror(left.right, right.left);
        } else if (left == null && right == null) {
            return true;
        } 
        return false;
    }
	
	
	//recursive
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            //push children
            stack.push(t1.right); 
            stack.push(t2.left);
            stack.push(t1.left); 
            stack.push(t2.right);
        }
        return true;
    }
    
    
}