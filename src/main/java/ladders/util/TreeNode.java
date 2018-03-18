package main.java.ladders.util;

public class TreeNode {
	
	public int val;
	public TreeNode left, right;
	public TreeNode parent;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
		this.parent = null;
		
	}
}
