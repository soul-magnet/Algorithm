package main.java.ladders.LinkedList;

/**
 * 174. Remove Nth Node From End of List - Easy

Given a linked list, remove the nth node from the end of list and return its head.

 Notice
The minimum number of nodes in list is n.


Example
Given linked list: 1->2->3->4->5->null, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5->null.

Challenge 
Can you do it without getting the length of the linked list?

Tags: Two Pointers Linked List

Related Problems 
Naive Middle of Linked List 41 %
Easy Delete Node in the Middle of Singly Linked List 48 %
 * */
/* Analysis:
 * Maintain two pointers; reference pointer and main pointer, 
 * initialize both reference pointer and main pointer to head.
 * First move reference pointer to n nodes from head
 * Now move both pointers one by one until reference pointer reaches end
 * Now main pointer will point to nth node from the end 
 * Return main pointer */
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
public class RemoveNthNodeFromEndOfTheList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
	
	ListNode removeNthFromEnd(ListNode head, int n){
		
		if (head == null || n <= 0){
			return null;
		}
		
		ListNode fast = new ListNode(0);
		ListNode slow = new ListNode(0);
		fast = head;
		slow = head;
		
		for (int i = 0 ; i < n ; i++){
			fast = fast.next;
		}
		
		// if remove the first node
		if (fast == null){
			head = head.next;
			return head;
		}
		
		while (fast.next != null){
			fast = fast.next;
			slow = slow.next;
			
		}
		
		slow.next = slow.next.next;
		return head;
	}
}
