package main.java.ladders.LinkedList;

/**
 * 113. Remove Duplicates from Sorted List II - Medium

Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

Tags 
Linked List
Related Problems 
Naive Remove Linked List Elements 21 %
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
public class RemoveDuplicatesFromSortedList2 {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	
    	while (head.next != null && head.next.next != null){
    		if (head.next.val == head.next.next.val){
    			int val = head.next.val;
    			while (head.next != null && head.next.val == val)
    				head.next = head.next.next;
    		} else {
    			head = head.next;
    		}
    	
    	}
    	return dummy.next;
    }
    
    //Juizhang Solution
//    if(head == null || head.next == null)
//   	 return head;
//   	 
//   	 ListNode dummy = new ListNode(0);
//   	 dummy.next = head;
//   	 head = dummy;
//   	 /*//head.next is cur, head is pre,since we need to jump all the ele to non dulplicated, 
//   	 //pre will jump to the non duplicated current
//   	 //if dulicated, record cur.val, while val==cur.next.value, update cur= cure.next,
//   	 //else head
//*/   	 while (head.next != null && head.next.next != null) {
//   	 if (head.next.val == head.next.next.val) {
//   	 int val = head.next.val;
//   	 while (head.next != null && head.next.val == val) {
//   	 head.next = head.next.next;
//   	 } 
//   	 } else {
//   	 head = head.next;
//   	 }
//   	 }
//   	 
//   	 return dummy.next;
//    }
//   	public ListNode deleteDuplicates(ListNode head) {
//   		if(head==null){
//   			return head;
//   		}
//   		ListNode dummy = new ListNode(0);
//   		dummy .next=head;
//   		head= dummy;
//   		while(head.next!=null&&head.next.next!=null){
//   			int temp = head.next.val;
//   			ListNode nnext= head.next.next;
//   			if(nnext!=null&&nnext.val==temp){
//   				while(head.next!=null&&head.next.val==temp){
//   					head.next=head.next.next;
//   				}
//   			}else{
//   				head=head.next;
//   			}
//   		}
//   		return dummy.next;
//   	}
}
