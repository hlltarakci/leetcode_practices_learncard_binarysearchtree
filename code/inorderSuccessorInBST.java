// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/998/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) -- for unbalanced trees, for balanced trees O(log n)
    */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return find(root, p.val + 1);
    }
    
    private TreeNode find(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        
        if(root.val < val) return find(root.right, val);
        
        TreeNode leftCase = find(root.left, val);
        return leftCase == null ? root : leftCase;
    }
}
