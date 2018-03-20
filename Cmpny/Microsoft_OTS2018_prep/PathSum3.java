package Microsoft_OTS2018_prep;
/**LeetCode
 * 437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, 
but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 
1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11


Related Topics :Tree

Similar Questions 
Path Sum
Path Sum II
Path Sum IV
Longest Univalue Path
 * 
 * */

import java.util.HashMap;
import java.util.Map;

import main.java.ladders.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSum3 {
	//DFS Approach-typical recursive
	//Time: O(n^2) worst case, no branching O(nlogn)in best case -balanced binary tree
    public int pathSum(TreeNode root, int sum) {
    	if(root == null) return 0;
    	return dfs(root, sum) + dfs(root.left, sum) + dfs(root.right, sum);
        
    }
    
    private int dfs(TreeNode node, int sum) {
    	if(node == null) return 0;
    	return (node.val == sum ? 1: 0) + 
    			dfs(node.left, sum - node.val) + 
    			dfs(node.right, sum - node.val);
    }
    
    //A better solution is suggested in 17ms O(n) java prefix sum. 
    //It use a hash map to store all the prefix sum and each time check if the any subarray sum to the target
    //https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-on-java-prefix-sum-method
    public int pathSum1(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum, map); 
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return res;
    }
}
