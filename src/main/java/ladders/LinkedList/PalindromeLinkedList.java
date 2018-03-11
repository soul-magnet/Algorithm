package main.java.ladders.LinkedList;
/**
 * 223. Palindrome Linked List - Medium 

Implement a function to check if a linked list is a palindrome.

Example
Given 1->2->1, return true

Challenge 
Could you do it in O(n) time and O(1) space?

Tags 
Linked List
Related Problems 
Easy Palindrome Number 36 %
Easy Valid Palindrome 24 %
Easy Reverse Linked List 40 %
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
	/**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
               if (head == null || head.next == null) {
            return true;
        }
        //find middle(slow.next)
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse mid to end
        ListNode postLast = null;
        ListNode Middle = slow.next;
        while (Middle != null) {
            ListNode temp = Middle;
            Middle = Middle.next;
            temp.next = postLast;
            postLast = temp;
        }
        
        while(postLast!=null&& head!=null&&postLast.val==head.val){
            postLast=postLast.next;
            head= head.next;
        }
        return postLast==null;
    }

}
