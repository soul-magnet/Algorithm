package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
	//hello
	//Solution 1: BFS 5ms
	public List<List<Integer>> verticalOrder(TreeNode root){
		
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> cols = new LinkedList<Integer>();
		
		queue.add(root);
		cols.add(0);
		int min = 0, max = 0;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int col = cols.poll();
			
			if(!map.containsKey(col)){
				map.put(col, new ArrayList<Integer>());
			}
			
			map.get(col).add(node.val);
			
			if(node.left != null){
				queue.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}
			
			if(node.right != null){
				queue.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}
		
		for(int i = min; i <= max; i++)
			result.add(map.get(i));
		
		return result;
		
	}
	
	//Solution 2: 3ms using DFS approach; handle the range from begining
	private int min = 0, max = 0;
	public List<List<Integer>> verticalOrderII(TreeNode root){
		
		 List<List<Integer>> result = new ArrayList<>();
		    if(root == null)    return result;
		    computeRange(root, 0);
		    for(int i = min; i <= max; i++) result.add(new ArrayList<>());
		    Queue<TreeNode> queue = new LinkedList<>();
		    Queue<Integer> cols = new LinkedList<>();
		    cols.add(-min); //how does this work?
		    queue.add(root);
		    while(!queue.isEmpty()){
		        TreeNode node = queue.poll();
		        int i = cols.poll();
		        result.get(i).add(node.val);
		        if(node.left != null){
		            queue.add(node.left);
		            cols.add(i - 1);
		        }
		        if(node.right != null){
		            queue.add(node.right);
		            cols.add(i + 1);
		        }
		    }
		    return result;
		
	}
	
	private void computeRange(TreeNode root, int cols){
	    if(root == null)    return;
	    min = Math.min(min, cols);
	    max = Math.max(max, cols);
	    computeRange(root.left, cols - 1);
	    computeRange(root.right, cols + 1);
	}

}
