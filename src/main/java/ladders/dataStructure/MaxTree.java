package DataStructure;

import java.util.LinkedList;

/*
 *Given an integer array with no duplicates. 
 *A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:

    6
   / \
  5   3
 /   / \
2   0   1
Challenge
O(n) time and memory.

*/
/*
 * Use a decreasing stack to store nodes.
 * 1. We are iterating the array from left to right. When we meet a new node N,
 * all nodes in the stack are on the left of the node N. We need to figure out the relationship
 * between these nodes and the node N(Find its left child & left parent)
 * 2. For node N, we first find its left child by popping each smaller node in the stack,
 *  and we make N as its right child(make it as N's left parent)
 * 3. Repeat step 2 and return the bottom of the stack, which is the largest
 * number (root).
 * 
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
public class MaxTree {
	/**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
	
	public TreeNode maxTree(int[] A){
		if (A == null || A.length == 0) {
			return null;
		}
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		for (int i = 0; i < A.length; i++){
			TreeNode cur = new TreeNode(A[i]);
			while(!stack.isEmpty() && cur.val > stack.peek().val){
				cur.left = stack.pop();
			}
			if (!stack.isEmpty()){
				stack.peek().right = cur;
			}
			
			stack.push(cur);
		}
		TreeNode result = new TreeNode(0);
		while(!stack.isEmpty()){
			result = stack.pop();
		}
		
		return result;
	}
     
     

}
