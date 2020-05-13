// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1013/

class Solution {
    /*
        n: arr length
        time: O(n log (min(n,k)))
        space: O(min(n,k))
    */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tree = new TreeSet<>();
        
        for(int i=0; i<nums.length; i++) {
            long num = (long)nums[i];
            // try next
            Long next = tree.ceiling(num);
            if(next != null && next-num <= t) return true;
            
            // try prev
            Long prev = tree.floor(num);
            if(prev != null && num-prev <= t) return true;
            
            tree.add(num);
            if(tree.size() > k) tree.remove((long)nums[i-k]);
        }
        
        return false;
    }
}
