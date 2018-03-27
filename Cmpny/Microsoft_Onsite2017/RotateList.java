package Microsoft_Onsite2017;

import main.java.ladders.util.ListNode;

/**Given a list, rotate the list to the right by k places, where k is non-negative.

 Have you met this question in a real interview? Yes
 Example
 Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.

 * Created by K25553 on 10/13/2016.
 * dummy pre, find pre kth, then find pre last kth and pre null,
 * prenull.next = dummmy.next, dummy.next= pre last kth.next, pre last kth.next=null;
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        int length = getLength(head);

        if(head==null||head.next==null||length==0||k % length==0){
            return head;
        }//find last kth
        k = k % length;
        ListNode dummy = new ListNode(0), pre=dummy;int i=0;dummy.next=head;
        while(i<k){
            if(head==null)return null;
            head= head.next; i++;
        }
        while(head !=null){
            head=head.next;
            pre=pre.next;
        }
        ListNode dumy1= pre.next,head1 = pre.next;
        pre.next=null;
        while(head1!=null&&head1.next!=null){
            head1 = head1.next;
        }
        head1.next=dummy.next;
        return dumy1;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next= head;
        head =dummy;
        int ct= 0;
        while(head.next!=null&&ct<k){
            head=head.next;
            ct++;
        }
        ListNode head1 = dummy;
        while(head.next!=null){
            head1 = head1.next;
            head= head.next;
        }
        head.next=dummy.next;
        dummy.next = head1.next;
        head1.next=null;
        return dummy.next;
    }
}
