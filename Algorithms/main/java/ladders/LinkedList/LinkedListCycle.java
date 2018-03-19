package main.java.ladders.LinkedList;
/**
 * 102. Linked List Cycle 

Given a linked list, determine if it has a cycle in it.

Example
Given -21->10->4->5, tail connects to node index 1, return true

Challenge 
Follow up:
Can you solve it without using extra space?

Tags: Two Pointers Linked List

Related Problems 
Medium Intersection of Two Linked Lists 39 %
 * */

import LinkedList.ListNode;

/* Analysis: 
 * If we have 2 pointers- fast and slow. It is guaranteed that the fast one will
 * meet the slow one if there exists a circle. 
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
public class LinkedListCycle {
	 /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if(head==null ||head.next==null){
            return false;
        }
        ListNode fast = head.next, slow= head;
       while(fast!=null&&fast.next!=null&&slow!=null&&fast!=slow){
           slow= slow.next; 
           fast=fast.next.next;
           
       } 
       if(fast==null||fast.next!=null||slow==null)return false;
       return true;
    }
    
    /////////////////////////////////
    public boolean hasCycle(ListNode head) {  
        if (head == null || head.next == null){
        	return false;
        }
        
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
        	if (fast == null || fast.next == null)
        		return false;
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return true;
    }

}
