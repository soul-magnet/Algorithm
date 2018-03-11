package main.java.ladders.LinkedList;
/**
 * 380. Intersection of Two Linked Lists - Medium

Write a program to find the node at which the intersection of two singly linked lists begins.

 Notice
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Have you met this question in a real interview? 
Example
The following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Challenge 
Your code should preferably run in O(n) time and use only O(1) memory.

Tags 
Linked List
Related Problems 
Hard Linked List Cycle II 37 %
Medium Linked List Cycle 45 %
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
public class IntersectionOfTwoLinkedList {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode tail = headA;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=headB;
        ListNode res= detectCirclePoint(headA);
        tail.next=null;
        return res;
    }

    private ListNode detectCirclePoint(ListNode head) {
        ListNode slow= head, fast= head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        slow = head;
        fast = fast.next;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    
}

