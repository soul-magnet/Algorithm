package main.java.ladders.LinkedList;
/**
 * 228. Middle of Linked List - Easy

Find the middle node of a linked list.

Example
Given 1->2->3, return the node with value 2.

Given 1->2, return the node with value 1.

Tags 
Linked List
Related Problems 
Easy Remove Nth Node From End of List 30 %
 * */

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MiddleOfLinkedList {
	/**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) { 
        // Write your code here
        if(head== null ||head.next==null){
            return head;
        }
        ListNode slow = head, fast = head.next;
        while(fast!= null&&fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        
        return slow;
    }

}
