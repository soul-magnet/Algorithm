package main.java.ladders.LinkedList;
/**
 * 451. Swap Nodes in Pairs - Easy

Given a linked list, swap every two adjacent nodes and return its head.

Have you met this question in a real interview? 
Example
Given 1->2->3->4, you should return the list as 2->1->4->3.

Challenge 
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Tags 
Linked List
Related Problems 
Medium Swap Two Nodes in Linked List 19 %
Hard Reverse Nodes in k-Group 35 %
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
          ListNode dummy = new ListNode(0);
        dummy.next = head;
        head= dummy;
        while(head.next!=null&&head.next.next!=null){
            ListNode n2 = head.next.next;
            ListNode n1= head.next;
            n1.next=n2.next;
            n2.next=n1;
            head.next=n2;
            head=n1;
        }
        return dummy.next;
    }
}

