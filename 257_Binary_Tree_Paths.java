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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        if(!Objects.isNull(root)) s.push(root);

        while (!s.empty()) {
            TreeNode node = s.peek();
            if(!Objects.isNull(node.left) && !set.contains(node.left)) {
                s.push(node.left);
            } else if(!Objects.isNull(node.right)&& !set.contains(node.right)) {
                s.push(node.right);
            } else {
                TreeNode temp = s.peek();
                if(Objects.isNull(temp.left) && Objects.isNull(temp.right)) {
                    result.add(toResult(s));    
                }
                set.add(s.pop());
            }
        }
        return result;
    }
    
    private String toResult(Stack<TreeNode> s) {
        return s.stream().map(n -> Integer.toString(n.val)).collect(Collectors.joining("->"));
    }
}



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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }
        
        if(root.left!=null) {
            for(String s: binaryTreePaths(root.left)) {
                result.add(Integer.toString(root.val) + "->" + s);
            }
        }
        
        if(root.right!=null) {
            for(String s: binaryTreePaths(root.right)) {
                result.add(Integer.toString(root.val) + "->" + s);
            }
        }
        return result;
    }
    
}

