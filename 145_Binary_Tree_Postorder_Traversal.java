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
    //stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(!Objects.isNull(root)) stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
                result.add(node.val);
                stack.pop();
            }

            if(!Objects.isNull(node.right)) {
                stack.push(node.right);
                node.right = null;
            }
            if(!Objects.isNull(node.left)) {
                stack.push(node.left);
                node.left = null;
            }

        }
        return result;
    }

//recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecurring(root, result);
        return result;
    }
    
    public void postorderTraversalRecurring(TreeNode root, List<Integer> result) {
        if (!Objects.isNull(root)) {
            postorderTraversalRecurring(root.left, result);
            postorderTraversalRecurring(root.right, result);
            result.add(root.val);
        }
    }
    





    
}