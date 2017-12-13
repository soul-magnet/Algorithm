package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	
	/**Solution 1: BFS Solution with one Queue*/
	public List<List<Integer>> levelOrderBFS(TreeNode root) {
		List result = new LinkedList<List<Integer>>();
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			List<Integer> level = new LinkedList<Integer>();
			int size = queue.size();
			
			for(int i = 0; i < size; i++){
				TreeNode head = queue.poll();
				level.add(head.val);
				if(head.left != null){
					queue.offer(head.left);
				}
				if(head.right != null){
					queue.offer(head.right);
				}
			}
			result.add(level);
		}
		
		return result;
	}
	
	/**Solution 2: DFS Solution*/
	
	public List<List<Integer>> levelOrderDFS(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfsHelper(result, root, 0);
		return result;
	}
	
	public void dfsHelper(List<List<Integer>> result, TreeNode root, int level){
		if(root == null) return;
		if(level >= result.size()){
			result.add(new LinkedList<Integer>());
		}
		
		result.get(level).add(root.val);
		dfsHelper(result, root.left, level+1);
		dfsHelper(result, root.right, level+1);
		
	}
	
	
	/**Solution 3: BFS two queues*/
	public List<List<Integer>> levelOrderBFS2(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null)  return result;
		
		List<TreeNode> Q1 = new ArrayList<TreeNode>();
		List<TreeNode> Q2 = new ArrayList<TreeNode>();
		
		Q1.add(root);
		while(Q1.size() != 0){
			List<Integer> level = new ArrayList<Integer>();
			Q2.clear();
			for(int i = 0 ;  i < Q1.size() ; i++){
				TreeNode node = Q1.get(i);
				level.add(node.val);
				
				if(node.left != null){
					Q2.add(node.left);
				}
				
				if(node.right != null){
					Q2.add(node.right);
				}
			}
			
			//swap q1 and q2
			List<TreeNode> temp = Q1;
			Q1 = Q2;
			Q2 = temp;
			
			//add to result
			result.add(level);
		}
		
		return result;
	}
}
