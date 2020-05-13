// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1012/

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
        h: height of tree -- unbalanced n, balanced log n
        time: O(h)
        space: O(h)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;
        if(root.left == null) return lowestCommonAncestor(root.right, p, q);
        if(root.right == null) return lowestCommonAncestor(root.left, p, q);
        
        TreeNode smaller = p.val < q.val ? p : q;
        TreeNode larger = smaller == p ? q : p;
        
        if(smaller.val < root.val && root.val < larger.val) return  root;
        if(larger.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
