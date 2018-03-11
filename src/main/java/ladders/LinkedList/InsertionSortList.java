package main.java.ladders.LinkedList;
/**
 * 173. Insertion Sort List - Easy
e
Sort a linked list using insertion sort.

Example
Given 1->3->2->0->null, return 0->1->2->3->null.

Tags: Sort Linked List

Related Problems 
Easy Insert into a Cyclic Sorted List 22 %
Medium Sort List 30 %
 * */

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
 */ 
public class InsertionSortList {
	/**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
	public ListNode insertionSortList(ListNode head){
		ListNode dummy = new ListNode(0);
		while (head != null){
			ListNode node = dummy;
			while (node.next != null && node.next.val < head.val){
				node = node.next;
			}
			ListNode temp = head.next;
			head.next = node.next;
			node.next = head;
			head = temp;
		}
		return dummy.next;
	}

}
