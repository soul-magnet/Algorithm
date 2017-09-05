package binarytree.divideAndConquer;

import java.util.LinkedList;
import java.util.List;

/**Given a binary tree, find all paths that sum of the nodes 
in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]
*/
public class BinaryTreePathSumII {
	/**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
	 public List<List<Integer>> binaryTreePathSumII(TreeNode root, int target) {
		 
		 List<List<Integer>>result = new LinkedList<List<Integer>>();
		 List<Integer> currentResult = new LinkedList<Integer>();
		 
		 pathSum(root, target, currentResult, result);
		 return result;
		 
	 }
	 
	 public void pathSum(TreeNode root, int target, List<Integer>currentResult, 
			 List<List<Integer>>result){
		 if(root == null){
			 return;
		 }
		 
		 currentResult.add(new Integer(root.val));
		 if(root.left == null && root.right == null && target == root.val){
			 result.add(new LinkedList(currentResult));
			 currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
		 }else {
			 pathSum(root.left, target - root.val, currentResult, result);
			 pathSum(root.right, target - root.val, currentResult, result);
		 }
		 
		 currentResult.remove(currentResult.size() - 1);
	 }

}
