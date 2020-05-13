// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/

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
    /*
        n: num of nodes
        h: tree height --- log n for balanced, n for unbalanced
        time: O(n h) --> since top down recursion
        space: O(h)
    */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int heightLeft = height(root.left);
        int heightRigth = height(root.right);
        
        if(Math.abs(heightLeft - heightRigth) > 1)
            return false;
            
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
