package main.java.ladders.LinkedList;

/**
 * 166. Nth to Last Node in List - Easy

Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.

Tags: Linked List Cracking The Coding Interview
 * */

/* Analysis: 
 * 1. Find the nth node in normal order
 * 2. Have a head at index0
 * 3. Move both head and nth node. When nth node hit null/end, 
 *    then the moving head is the nth to last node in list. 
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
public class NthToLastNodeInList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        
    	if (head == null || n < 0){
    		return null;
    	}
    	
    	int count = 0;
    	ListNode node = head;
    	while (node != null && count < n){
    		node = node.next;
    		count++;
    				
    	}
    	
    	while (node != null){
    		node = node.next;
    		head = head.next;
    	}
    	return head;
    }
}

