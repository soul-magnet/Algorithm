package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

Tags: Queue LinkedIn Binary Tree Binary Tree Traversal Breadth First Search

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

//Thoughts
/*
 * Use Two Stacks and One boolean flag to switch the order
 * release the current level into ArrayList and store the next level
 * while current stack is not empty
 * current stack.pop node
 * flag is in Order1 form left to right
 * next.push node.left
 * next.push node.right
 * else(right to left)
 * next stack.push node.right
 * next stack.push node.left
 * level(ArrayList).add(node.val)
 * swap current stack to the next stack
 * change the flag to reverse flag
 * result.add(level)
 * */
class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = left = this.right = null;;
	}
}
public class BinaryreeZigzagLevelOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
	//Using Stacks
	List<List<Integer>>zigzagLevelOrder1(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		
		Stack<TreeNode>now = new Stack<TreeNode>();
		Stack<TreeNode>next = new Stack<TreeNode>();
		
		now.push(root);
		boolean order = true;
		
		while(!now.isEmpty() || !next.isEmpty()) {
			List<Integer>level = new ArrayList<Integer>();
			TreeNode node = now.pop();
			while(!now.isEmpty()) {
				if(order){
					if(node.left != null)
						next.push(node.left);
					if(node.right != null)
						next.push(node.right);
				}else {
					if(node.right != null)
						next.push(node.right);
					if(node.left != null)
						next.push(node.left);
				}
				level.add(node.val);
			}
			result.add(level);
			order = !order;
			Stack<TreeNode> tmp = now;
			now = next;
			next = tmp;
		}
		
		return result;
		
	}
	
	//Using Queue
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		int level = 0;
		
		while(!queue.isEmpty()) {
			ArrayList<Integer>tempList = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode curr = queue.remove();
				
				if(level % 2 == 0) {
					tempList.add(curr.val);
				}else {
					tempList.add(0, curr.val); //tricky - ambiguous
				}
				
				if(curr.left != null)
					queue.offer(curr.left);
				
				if(curr.right != null)
					queue.offer(curr.right);
			}
			
			level++;
			result.add(tempList);
			
		}
		
		return result;
	}

}
