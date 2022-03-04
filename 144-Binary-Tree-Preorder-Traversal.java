
class Solution {
    
    //stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(!Objects.isNull(root)) stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(!Objects.isNull(node.right)) stack.push(node.right);
            if(!Objects.isNull(node.left)) stack.push(node.left);
        }
        return result;
    }
    //recursive
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecurring(root, result);
        return result;
    }

    public void preorderTraversalRecurring(TreeNode root, List<Integer> result) {
        if (!Objects.isNull(root)) {
            result.add(root.val);
            preorderTraversalRecurring(root.left, result);
            preorderTraversalRecurring(root.right, result);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

}