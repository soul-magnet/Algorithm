package main.java.ladders.LinkedList;
/**
 * 167. Add Two Numbers - Easy

You have two numbers represented by a linked list, where each node contains a single digit. 
The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.

Tags: Linked List Cracking The Coding Interview High Precision

Related Problems 
Medium Add Two Numbers II 24 %
Easy Big Integer Addition 27 %
Medium Big Integer multiplication 27 %
 * */

/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/
public class AddTwoNumbers {
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2){
       String a = "", b="";
        ListNode dummy1 = new ListNode(0);
        ListNode tail1 = dummy1;
        tail1.next= l1;
        ListNode dummy2 = new ListNode(0);
        ListNode tail2= dummy2;
        tail2.next= l2;
        ListNode dummy3 = new ListNode(0);
        ListNode tail3= dummy3;
        //tail3.next= null;
        int carry = 0;
        while (tail1.next!=null||tail2.next!=null){
            while(tail1.next!=null&&tail2.next!=null)
            { int res= tail1.next.val+tail2.next.val+ carry;
                carry= res/10;
                tail3.next= new ListNode(res);
                tail3= tail3.next;
                tail1= tail1.next;
                tail2= tail2.next;
            }
            while(tail1.next!=null){
                int res= tail1.next.val+ carry;
                carry= res/10;
                tail3.next= new ListNode(res);
                tail3= tail3.next;
                tail1= tail1.next;
            }

            while(tail2.next!=null){
                int res= tail2.next.val+ carry;
                carry= res/10;
                tail3.next= new ListNode(res);
                tail3= tail3.next;
                tail2= tail2.next;
            }
            
        }
          if(carry==1){
            tail3.next= new ListNode(1);
        }
       return dummy3.next;
    }
    
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
//		if (l1 == null && l2 == null){
//			return null;
//		}
//		ListNode head = new ListNode(0);
//		ListNode point = head;
//		int carry = 0; 
//		while (l1 != null && l2 != null){
//			int sum = carry  + l1.val + l2.val;
//			point.next = new ListNode(sum % 10);
//			carry = sum / 10;
//			l1 = l1.next;
//			l2 = l2.next;
//			point = point.next;
//		}
//		
//		while (l1 != null){
//			int sum = carry + l1.val;
//			point.next = new ListNode(sum % 10);
//			carry = sum/10;
//			l1 = l1.next;
//			point = point.next;
//		}
//		
//		while (l2 != null){
//			int sum = carry + l2.val;
//			point.next = new ListNode(sum % 10);
//			carry = sum /10;
//			l2 = l2.next;
//			point = point.next;
//		}
//		
//		if(carry != 0){
//			point.next = new ListNode(carry);
//		}
//		return head.next;
//	}
}
