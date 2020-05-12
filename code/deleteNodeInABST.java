// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1006/

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
        h: height of tree -- worst case unbalanced n, average case balanced log n
        time: O(h)
        space: O(h)
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) {
            // case: has no children
            if(root.left == null && root.right == null) return null;
            // case: has one child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            // case: has two child -- replace with successor
            else {
                TreeNode s = successor(root);
                root.val = s.val;
                root.right = deleteNode(root.right, s.val);
                return root;
            }
        }
        else if(key < root.val) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        
        return root;
    }
    
    private TreeNode successor(TreeNode root) {
        if( root == null ) return null;
        
        TreeNode curr = root.right;
        while(curr.left != null) curr = curr.left;
        
        return curr;
    }
}
