package main.java.ladders.LinkedList;
/**
 * 11. Swap Two Nodes in Linked List - Medium

Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. 
It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, 
do nothing.

 Notice
You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.

Have you met this question in a real interview? 
Example
Given 1->2->3->4->null and v1 = 2, v2 = 4.

Return 1->4->3->2->null.

Tags: Linked List
Related Problems 
Easy Swap Nodes in Pairs 35 %
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapTwoNodesInLinkedList {
	/**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
                ListNode dummy = new ListNode(0);
        dummy.next= head;
        head= dummy;
        ListNode n1 = new ListNode(0), n2= new ListNode(0);

        while(head.next!=null&&head.next.val!=v1&&head.next.val!=v2){
            head= head.next;
        }
        if(head.next==null){
            return dummy.next;
        }
        if (head.next.val==v1||head.next.val==v2){
            n1=head;
            head=head.next;
        }
        while(head.next!=null&&head.next.val!=v1&&head.next.val!=v2){
            head=head.next;
        }
        if(head.next==null){
            return dummy.next;
        }//imp: consider n1->2
        
        if (head.next.val==v1||head.next.val==v2){
            n2=head;
            ListNode n11= n1.next;
            ListNode n22=n2.next;
            ListNode n23= n22.next;
            if(n1.next==n2){
                n1.next= n22;
                n22.next=n11;
                n11.next=n23;
            }else{
                n1.next=n22;
                n2.next=n11;
                n22.next=n11.next;
                n11.next=n23;

            }
        }

        return dummy.next;
    }

}
