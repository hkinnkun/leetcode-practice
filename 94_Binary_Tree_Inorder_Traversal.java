import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

class Solution {

    //stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode traversing = root;
        while (!Objects.isNull(traversing) || !stack.empty()) {
            if (!Objects.isNull(traversing)) {
                stack.push(traversing);
                traversing = traversing.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                traversing = temp.right;
            }
        }
        return result;
    }

    //recursive
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecurring(root, result);
        return result;
    }

    public void inorderTraversalRecurring(TreeNode root, List<Integer> result) {
        if (!Objects.isNull(root)) {
            inorderTraversalRecurring(root.left, result);
            result.add(root.val);
            inorderTraversalRecurring(root.right, result);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}