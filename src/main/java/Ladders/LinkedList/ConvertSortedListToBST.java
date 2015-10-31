package LinkedList;

import DataStructure.TreeNode;

/* Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.

 * Example: 
               2
1->2->3  =>   / \
             1   3
             
*Analysis:
*If you are given an array, the problem is quite straightforward. 
*But things get a little more complicated when you have a singly linked list
*instead of an array. Now you no longer have random access to an element in O(1)
*Therefore you need to create nodes bottom-up, and assign them to its parents.
*The bottom-up approach enables us to access the list in its order at the same time
*as creating nodes.
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
public class ConvertSortedListToBST {
	/**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
	private ListNode current;
	private int getListLength(ListNode head){
		int size = 0;
		while (head != null){
			size++;
			head = head.next;
		}
		return size;
	}
    public TreeNode sortedListToBST(ListNode head) {  
       int size ;
       current = head;
       size = getListLength(head);
       return sortedListToBSTHelper(size);
    }
    // build tree bottom-up
	private TreeNode sortedListToBSTHelper(int size) {
		if (size <= 0)
			return null;
		TreeNode left = sortedListToBSTHelper(size / 2);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
		root.left = left;
		root.right = right;
		
		return root;
	}
	
	/*
	 * static ListNode h;
 
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}*/
}
