package Ladders;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
	// Iterative 
	public ArrayList<Integer> postorderTraversal (TreeNode root) {
		
		ArrayList<Integer> nodeVal = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if (root == null){
			return nodeVal;
		}
		
		TreeNode prev = null;
		TreeNode curr = root;
		
		stack.push(root);
		while (!stack.empty()) {
			curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr){
				if (curr.left != null){
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				}
			} else if (curr.left ==prev){
				if (curr.right != null){
					stack.push(curr.right);
				}
			} else {
				nodeVal.add(curr.val);
				stack.pop();
			}
			
			prev = curr;
		}
		
		return nodeVal;
	}
	
	/**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
     // recursive solution
    /*public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> nodeVal = new ArrayList<Integer>();
        
        if (root == null){
            return nodeVal;
        }
        
        nodeVal.addAll(postorderTraversal(root.left));
        nodeVal.addAll(postorderTraversal(root.right));
        nodeVal.add(root.val);
        
        return nodeVal;
        
    }*/
    

}
