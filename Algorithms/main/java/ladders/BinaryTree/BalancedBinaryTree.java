package main.java.ladders.BinaryTree;
/**
 * 93. Balanced Binary Tree - Easy - Required

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in 
which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.

Tags 
Divide and Conquer Recursion
Related Problems 
Medium Validate Binary Search Tree 22 %
 * */

//Thoughts: RECURSIVE -The function call stack corresponds to a sequence of calls from the root through 
//the unique path to a current node, and the stach height is therefore bounded by 
//the height of the tree, leading on an O(h) space bounnd. 
//The time complexity is the same as postprder traversal O(n)


/* Analysis: Use recursion*/
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


public class BalancedBinaryTree {
   /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
	    if(root == null) return true;
            return maxDepth(root) != -1;
    }

	private int maxDepth(TreeNode root) {
		if (root == null) return 0;
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
// 		if (leftDepth == -1 || right == -1 || Math.abs(left - right) > 1){
// 			return -1;
// 		}
		
		if(leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1){
			return Integer.MIN_VALUE;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////
//Thoughts: ITERATIVE
// We do depth-first walk through out tree, keeping track of the depth as we go, 
// when we find a leaf, we throw its depth into a list of depths 
// if we haven't seen that depth already. Each time we hit a leaf with a new depth,
// there are two ways that our tree might noe be unbalanced
// 1. If there are more than 2 different leaf depths
// 2. if there are exactly 2 leaf depths and they are more than 1 apart.
//  Why DFS not BFS? DFS reaches leaves faster, which allows us to short-circuit earlier in some cases.
 
private static class NodeDepthPair {

    BinaryTreeNode node;
    int depth;

    NodeDepthPair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public boolean isBalanced(TreeNode root) {
 	if(root == null) return true;
	 //short-circuit as soon as we find more than 2
	 List<integer> depths = new ArrayList<>(3);
	 
	// nodes will store pairs of a node and the node's depth
	 Stack<NodeDepthPair> nodes = new Stack<>();
	 nodes.push(new NodeDepthPair(root, 0));
	
	while(!nodes.empty()){
		// pop a node and its depth from the top of our stack
		NodeDepthPair nodeDepthPair = nodes.pop();
		TreeNode node = nodeDepthPair.node;
		int depth = nodeDepthPair.depth;
		
		//case:we found a leaf
		if(node.left == null && node.right == null){
			//we only care if it's a new depth
			if(!depths.contains(depth)){
				depths.add(depth);
				
				 // two ways we might now have an unbalanced tree:
                		//   1) more than 2 different leaf depths
                		//   2) 2 leaf depths that are more than 1 apart
				if(depths.size() > 2 || (depths.size() == 2 && 
					Math.abs(depths.get(0) - depths.get(1)) > 1)){
					return false;
				}
			 // case: this isn't a leaf - keep stepping down	
			}else{
				if(root.left != null){
					nodes.push(new NodeDepthPair(node.left, depth+1));
				}
				
				if(root.right != null){
					nodes.push(new NodeDpethPair(node.right, depth+1));
				}
			}
		}
		
		return true;
		
	}
 }
////////////////////////////////////////////////////////////////////////////////////////////////////
//similar approach: from Elements of Programming Interviews
//Chapter:9 Problem: 9.1

private static class BalanceStatuswithHeight{
	public boolean balanced;
	public int height;
	
	public BalanceStatuswithHeight(boolean balanced, int height){
		this.balanced = balanced;
		this.height = height;
	}
}

public static boolean isBalanced(TreeNode<Integer> tree){
	return checkBalanced(tree).balanced;
}

private static BalanceStatuswithHeight checkBalanced(TreeNode<Integer> tree){
	if(tree == null){
		return new BalanceStatuswithHeight(true, -1); //base case
	}
	
	BalanceStatuswithHeight leftResult = checkBalanced(tree.left);
	if(!lefResult.balanced){
		return leftResult; //leftSubtree is not balanced
	}
	
	BalanceStatuswithHeight rightResult = checkBalanced(tree.right);
	if(!rightResult.balanced){
		return rightResult; //rightSubtree is not balanced
	}
	
	boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
	int height = Math.max(leftResult.height, rightResult.height) + 1;
	
	return new BalanceStatuswithHeight(isBalanced, height);
}
