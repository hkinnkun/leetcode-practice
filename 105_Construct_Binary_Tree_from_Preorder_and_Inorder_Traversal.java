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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(preorder.length==0 && inorder.length==0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int indexForLeftSubTree = 0;
        for(int i = 0; i < inorder.length; i ++) {
            if(inorder[i] == rootVal) {
                indexForLeftSubTree = i - 1;
                break;
            }
        }
        int leftSubTreeLen = indexForLeftSubTree+1;
        int rightSubTreeLen = n - leftSubTreeLen - 1;
        int[] preorderLeft = new int[leftSubTreeLen];
        int[] inorderLeft = new int[leftSubTreeLen];
        int[] preorderRight = new int[rightSubTreeLen];
        int[] inorderRight = new int[rightSubTreeLen];
        //System.out.println("n is " + n + " leftSubTreeLen:"+leftSubTreeLen + " rightSubTreeLen:"+rightSubTreeLen);
        System.arraycopy(preorder, 1, preorderLeft, 0, leftSubTreeLen);
        System.arraycopy(inorder, 0, inorderLeft, 0, leftSubTreeLen);
        System.arraycopy(preorder, 1 + leftSubTreeLen, preorderRight, 0, rightSubTreeLen);
        System.arraycopy(inorder, 1+leftSubTreeLen, inorderRight, 0, rightSubTreeLen);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        

        return root;
    }
}
