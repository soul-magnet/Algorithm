package main.java.ladders.BinaryTree;

import util.TreeNode;
//trying to create concrete logic in this mainstream question
//revise 
/*Convert a binary search tree to doubly linked list with in-order traversal.


Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5

Tags: Linked List

*/
class DoublyListNode {
	int val;
	DoublyListNode next, prev;
	DoublyListNode(int val){
		this.val = val;
		this.next = this.prev = null;
	}
}
public class ConvertBSTToDoublyLinkedlist {
	
	public DoublyListNode bstToDoublyList(TreeNode root){
		DoublyListNode dummy = new DoublyListNode(0);
		DoublyListNode tail = dummy;
		dfs(root, tail);
		return dummy.next;
	}
	
	private DoublyListNode dfs(TreeNode root, DoublyListNode tail){
		
		if(root == null){
			return tail;
		}
		
		if(root.left == null && root.right == null){
			DoublyListNode crt = new DoublyListNode(root.val);
			tail.next = crt;
			crt.prev = tail;
			return crt;
		}
		//inorder traversal
		DoublyListNode left = dfs(root.left, tail); //get the left tree
		DoublyListNode crt = new DoublyListNode(root.val); //get the root
		left.next = crt;
		crt.prev = left;
		DoublyListNode right = dfs(root.right, crt); //get the right tree
		return right;
	}

}
