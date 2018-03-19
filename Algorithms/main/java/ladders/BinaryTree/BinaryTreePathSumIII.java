package main.java.ladders.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Your are given a binary tree in which each node contains a value. 
 * Design an algorithm to get all paths which sum to a given value. 
 * The path does not need to start or end at the root or a leaf, 
 * but it must go in a straight line down
 * Example: Given a binary tree:

    1
   / \
  2   3
 /   /
4   2
for target = 6, return

[
  [2, 4],
  [1, 3, 2]
]*/

public class BinaryTreePathSumIII {
	
	//Thoughts: The idea is similar two sum using hashmap to store
	//key: the prefix sum, value: how many ways to get prefix sum
	//whenever we reach a node we check if prefixsum - target exist in hashmap or not
	//if it does we added up the ways of prefix sum - target into res.
	 /*public List<List<Integer>> binaryTreePathSum3(TreeNode root, int sum){
		 
	 }*/
	 
	 //Thoughts:Recursive DFS
	 //Space O(n), Time O(n^2) in worst case(no branhing), O(nlogn) in best case(balanced tree)
	 /*public List<List<Integer>> binaryTreePathSum3V2(TreeNode root, int target) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 ArrayList<Integer> buffer = new ArrayList<Integer>();
		 
		 if(root == null){
			 return result;
		 }
		 return findSum(root, target);
	 }
	 
	 public void findSum(TreeNode node, int target){
		 if(node == null){
			 return;
		 }
		 
		 return (node.val == target ? 1 : 0)
	 }*/
//revisit	 
	    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
	        // Write your code here
	        
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }
	        
	        List<Integer> list = new ArrayList<>();
	        helper(root, result, list, target);
	        return result;
	    }
	    
	    public void helper(TreeNode root, List<List<Integer>> result, List<Integer> buffer, int target) {
	        
	        if (root == null) {
	            return;
	        }
	        
	        buffer.add(root.val);
	        int sum = 0;
	        for (int i = buffer.size() - 1; i >= 0; i--) {
	            sum += buffer.get(i);
	            if (sum == target) {
	                List<Integer>tempRes = new ArrayList<>();
	                for (int j = i; j < buffer.size(); j++) {
	                    tempRes.add(buffer.get(j));
	                }
	                result.add(tempRes);
	            }
	        }
	        
	        helper(root.left, result, buffer, target);
	        helper(root.right, result, buffer, target);
	        list.remove(buffer.size() - 1);// this deletes current pathsum and leave all previous sums
	    }
	 
}
