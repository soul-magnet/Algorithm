package main.java.ladders.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



/** 69. Binary Tree Level Order Traversal - Easy
 
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Challenge 
Challenge 1: Using only 1 queue to implement it.

Challenge 2: Use DFS algorithm to do it.

Tags: LinkedIn Facebook Microsoft Binary Tree Traversal Queue Binary Tree Breadth First Search Uber

Related Problems 
Medium Binary Tree Vertical Order Traversal 31 %
*/


 /* Analysis:
 * Method1: There are basically two functions in this method. 
 * One is to print all nodes at a given level(printGivenLevel), 
 * and other is to print level order traversal of the tree(printLevelorder)
 * printLevelorder makes use of printGivenLevel to print nodes at all levels
 * one by one starting from root. 
 * - Time Complexity: O(n^2) in worst case. 
 * Algorithm: 
 * 
 *Function to print level order traversal of tree
 *
 *printLevelorder(tree)
 *for d = 1 to height(tree)
 *	printGivenLevel(tree, d);
 *
 *Function to print all nodes at a given level
 *
 *printGivenLevel(tree, level)
 *if tree is NULL then return;
 *if level is 1, then
 *	print(tree.data);
 *else if level greater than 1, then 
 *	printGivenLevel(tree.left, level-1);
 *	printGivenLevel(tree.right, level-1);
 * 
 * Method 2: USE QUEUE, BFS 
 * public void levlOrder(Node root){
 * 		Queue<Node> queue = new LinkedList<Node>();
 * 		queue.offer(root);
 * 		System.out.println();
 * 		while(queue.size() > 0){
 * 			root = queue.poll();
 * 			System.out.println(root.data + " ");
 * 			if (root.left != null){
 * 				queue.add(root.left);
 * 			}
 * 			if (root.right != null){
 * 				queue.add(root.right);
 * 			}
 * 		}
 * }
 * 
 * 
 * */

/**
 * Space and Time Complexity 
 * Time: O(n)
 * Space: We are not using constant amount of memory to implement this algorithm, 
 * We are using queue, which is shrinking and enlarging.
 * Assuming that the queue is dynamic, so if we say each node has only one child, then we can assume that 
 * space comp is gonna be O(1) - best case
 * but we are are talking about the complete binary treee, then the space comp is gonna be O(n) - worst case,
 * since the depest node level is n/2
 * Also average space comp is gonna be O(n)
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null){
        	return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int size = queue.size();
        	for (int i = 0; i < size; i++){
        		TreeNode head = queue.poll();
        		level.add(head.val);
        		if (head.left != null){
        			queue.offer(head.left);
        		}
        		if (head.right != null){
        			queue.offer(head.right);
        		}
        	}
        	result.add(level);
        }
        return result;
    }
}
