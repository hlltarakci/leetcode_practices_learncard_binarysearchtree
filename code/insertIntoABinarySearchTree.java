// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1003/

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
        h: tree height -- worst case unbalanced tree n, average case balanced tree log n
        time: O(h)
        space: O(h) -- recursive case 
               O(1) -- iterative case
    */
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBSTRec(root, val);
    }
    
    public TreeNode insertIntoBSTRec(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) return node;
        
        if(val <= root.val) root.left = insertIntoBSTRec(root.left, val);
        else root.right = insertIntoBSTRec(root.right, val);
        
        return root;
    }
    
    public TreeNode insertIntoBSTIter(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) return node;
        
        TreeNode curr = root;
        while(curr != null) {
            if(val <= curr.val) {
                if(curr.left == null) {
                    curr.left = node;
                    break;
                }
                curr = curr.left;
            } else {
                if(curr.right == null) {
                    curr.right = node;
                    break;
                }
                curr = curr.right;
            }
        }
        
        return root;
    }
}
