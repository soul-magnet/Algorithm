package main.java.ladders.LinkedList;
/**
 * 452. Remove Linked List Elements 

Remove all elements from a linked list of integers that have value val.

Have you met this question in a real interview? 
Example
Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5

Tags 
Linked List
Related Problems 
Medium Remove Duplicates from Sorted List II 28 %
Easy Remove Duplicates from Sorted List 38 %
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
	 /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy= new ListNode(0);
		dummy.next= head;
		ListNode pre = dummy;
		while(pre.next!=null){
			if(pre.next.val==val){
				pre.next=pre.next.next;
			}else{
			    pre=pre.next;
			}
			
		}
		return dummy.next;
    }

}
