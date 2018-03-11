package main.java.ladders.LinkedList;
/**
 * 112. Remove Duplicates from Sorted List - Easy

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Tags 
Linked List
Related Problems 
Naive Remove Linked List Elements 21 %
 * */

/**
* Definition for ListNode
* public class ListNode {
* int val;
* ListNode next;
* ListNode(int x) {
* val = x;
* next = null;
* }
* }
*/
public class RemoveDuplicatesFromSortedList {
	/**
	 * @param ListNode head is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	 public static ListNode deleteDuplicates(ListNode head) { 
	        if(head==null){
	            return head;
	        }
	        ListNode node = head;
	        while(node!=null&&node.next!=null){
	            if(node.val==node.next.val){
	                node.next=node.next.next;
	            }else{
	                node=node.next;
	            }
	        }
	        return head;
	 } 

}
