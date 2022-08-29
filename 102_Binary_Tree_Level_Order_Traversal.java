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
    //from left to right, level by level
    //use a Set<TreeNode> to record the node at the same level
    // use another Set<TreeNode> to record the next level, then swap the levelSet
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        Set<TreeNode> levelSet = new HashSet<>();
        if(root != null) {
            levelSet.add(root);
            deque.add(root);
        }
        
        while(!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Set<TreeNode> nextLevelSet = new HashSet<>();
            while(!levelSet.isEmpty()){
                TreeNode node = deque.remove();
                levelSet.remove(node);
                level.add(node.val);
                if(node.left != null) {
                    deque.add(node.left);
                    nextLevelSet.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                    nextLevelSet.add(node.right);
                }
            }
            result.add(level);
            levelSet = nextLevelSet;
        }
        return result;
    }
}



------------
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
    //from left to right, level by level
    //use the size in the queue to determine the node at the same level
    //each while will handle one level
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root != null) deque.add(root);
        
        while(!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            while(size > 0){
                TreeNode node = deque.remove();
                level.add(node.val);
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
                size--;
            }
            result.add(level);
        }
        return result;
    }
}

