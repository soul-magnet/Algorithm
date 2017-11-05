package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BinarySearch.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 */

public class BinaryTreeLevelOrderTraversal {
	 /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList result = new ArrayList();
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
		}
		
		
	}

}
