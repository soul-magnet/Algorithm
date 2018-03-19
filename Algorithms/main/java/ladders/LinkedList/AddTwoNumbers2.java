package main.java.ladders.LinkedList;
/**
 * 221. Add Two Numbers II - Medium

You have two numbers represented by a linked list, where each node contains a single digit. 
The digits are stored in forward order, such that the 1's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.
 
Example
Given 6->1->7 + 2->9->5. That is, 617 + 295.

Return 9->1->2. That is, 912.

Tags: Linked List High Precision

Related Problems 
Easy Big Integer Addition 27 %
Medium Big Integer multiplication 27 %
Easy Add Two Numbers 21 %
Easy Reverse Linked List 40 %
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null; 
 * }
 * }
 */
public class AddTwoNumbers2 {
	 /**
	 * @param l1: the first list
	 * @param l2: the second list
	 * @return: the sum list of l1 and l2 
	 */
	     public ListNode addLists2(ListNode l1, ListNode l2) {
	        ListNode r1= reverse (l1);
	        ListNode r2= reverse (l2);
	        int carry = 0;
	        ListNode dummy = new ListNode(0);
	        dummy.next = r1;
	        ListNode head1= dummy;
	        while(r1!=null&& r2!=null){
	            int sum= r1.val+r2.val+carry;
	            carry= sum/10;
	            dummy.next.val= sum;
	            dummy=dummy.next;
	            r1= r1.next;
	            r2= r2.next;
	        }
	        while(r1!=null){
	            int sum= r1.val+carry;
	            carry= sum/10;
	            dummy.next.val= sum;
	            dummy=dummy.next;
	            r1= r1.next;
	        }
	        while(r2!=null){
	            int sum= r2.val+carry;
	            carry= sum/10;
	            r2.val= sum;
	            dummy.next= new ListNode(r2.val);
	            dummy= dummy.next;
	            r2= r2.next;
	        }
	        if(carry==1){
	            dummy.next= new ListNode(1);
	        }
	        return reverse(head1.next);
	    }
	    public ListNode reverse(ListNode head){
	        if(head==null|| head.next==null){
	            return head;
	        }
	        ListNode postLast=null;
	        while (head!=null){
	            ListNode temp = head;
	            head= head.next;
	            temp.next=postLast;
	            postLast=temp;
	        }
	        return postLast;
	    }

}
