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
    
    private int globalMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] p = longestDistanceFromRoot(root);
        return Math.max(p[0] + p[1], globalMax);
    }
    
    public int[] longestDistanceFromRoot(TreeNode root) {
        //System.out.println("node is " + root.val);
        int[] p = {0, 0};
        if(root.left == null && root.right == null) {
            return p;
        } else {
            if(root.left != null) {
                int[] temp = longestDistanceFromRoot(root.left);
                p[0] = Math.max(temp[0], temp[1]) + 1;
            }
            if(root.right != null) {
                int[] temp = longestDistanceFromRoot(root.right);
                p[1] = Math.max(temp[0], temp[1]) + 1;
            }
        }
        globalMax = Math.max(p[0] + p[1], globalMax);
        return p;

    }
}
