package Ladders;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> nodeVal = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode curr = root;
		
		while (curr != null || !stack.empty()){
			while(curr != null){
				stack.add(curr);
				curr = curr.left;
			}
			
			curr = stack.peek();
			stack.pop();
			
			nodeVal.add(curr.val);
			curr = curr.right;
		}
		
		return nodeVal;
	}

}
