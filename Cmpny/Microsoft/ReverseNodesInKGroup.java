package Microsoft;
/**
 * 450. Reverse Nodes in k-Group - Hard - Required

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Example
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Tags: Linked List Microsoft Facebook

Related Problems 
Easy Reverse Array 49 %
Easy Swap Nodes in Pairs 35 %
Medium Rotate List 25 %
Medium Reverse Linked List II 30 %
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
public class ReverseNodesInKGroup {
	class ResultType {
        public ListNode head, tail;

    }
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int len = getLength(head);
        if (len<k){
            return head;
        }
        int ct = len/k;
        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ResultType res = reverse(dummy.next,k);
        ListNode newHead =res.head;
        for(int i =1; i<ct; i++) {
            ResultType prevs = res;
            res = reverse(res.tail.next, k);
            prevs.tail.next=res.head;
        }
        return newHead;
    }

    private ResultType reverse(ListNode head, int k) {
        ResultType res = new ResultType();
        res.tail=head;
        ListNode postLast = null;
        int ct =0;
        while(head!=null&&ct<k ){
            ListNode crt = head;
            head= head.next;
            crt.next=postLast;
            postLast=crt;
            ct++;
        }
        res.head= postLast;
        if (head!=null){
            res.tail.next= head;
        }
        return res ;
    }

    public int getLength(ListNode head){
        ListNode node = head;
        int ct = 0;
        while(node!=null){
            ct++;
            node= node.next;
        }
        return ct;
    }

}
