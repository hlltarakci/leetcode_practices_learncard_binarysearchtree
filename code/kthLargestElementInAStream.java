// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1018/

class KthLargest {
    /*
        n: num of nodes
        h: tree height -- n for unbalanced, log n for balanced
        time: O(h) -- for search/insert -- O(n h) for all
        space: O(h) -- for search/insert -- O(n h) for all
    */
    class Node{
        public int val;
        public Node left;
        public Node right;
        public int count;
        public Node(int val) {
            this.val = val;
        }
    }
    
    int K;
    Node root;

    public KthLargest(int k, int[] nums) {
        root = null;
        for(int num: nums) root = addToTree(root, num);
        
        this.K = k;
    }
    
    private Node addToTree(Node node, int num) {
        if(node == null) {
            node = new Node(num);
            node.count = 1;
            return node;
        }
        
        if(node.val <= num) node.right = addToTree(node.right, num);
        else node.left = addToTree(node.left, num);
        
        node.count = 1;
        if(node.left != null) node.count += node.left.count;
        if(node.right != null) node.count += node.right.count;
        
        return node;
    }
    
    private int kthLargestRec(Node node, int k) {
        if(node == null || k <= 0) return -1;
        
        int at= node.right != null ? node.right.count + 1 : 1;
        
        if(at == k) return node.val;
        if(at < k) return kthLargestRec(node.left, k - at);
        return kthLargestRec(node.right, k);
    }
    
    public int add(int num) {
        root = addToTree(root, num);
        
        return kthLargestRec(root, K);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
