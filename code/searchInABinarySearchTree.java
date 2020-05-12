// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1000/

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
        h: tree height -- n for unbalanced tree, log n for balanced tree
        time: O(h)
        space: O(h) 
    */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        if(val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
