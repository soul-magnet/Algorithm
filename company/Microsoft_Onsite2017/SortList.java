/**
 * 
 */
package MS.Onsite2017;

import list.ListNode;

/**Sort a linked list in O(n log n) time using constant space complexity.
 * @author K25553
 *merge sort
 */
public class SortList {
	//merge sort
	 public ListNode sortList2(ListNode head) {
		if( head==null||head.next==null){
			return head;
		}
		ListNode mid = getMid(head);
		ListNode right =sortList2(mid.next);
		mid.next=null;
		ListNode left = sortList2(head);
		 
		 return merge(left,right);
		 
	 }
	 
	 private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(left != null && right != null){
			if(left.val<right.val){
				tail.next=left;
				left=left.next;
			}else{
				tail.next=right;
				right=right.next;
			}
			tail=tail.next;
		}
		if(left != null){
			tail.next=left;
		}else{
			tail.next=right;
		}
		return dummy.next;
	}

	public ListNode getMid(ListNode head){
		ListNode fast=head.next, slow = head;
		while(fast !=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	class Pair {
		public ListNode first, second;
		public Pair(ListNode first, ListNode second) {
			this.first = first;
			this.second = second;
		}
	}
	public ListNode sortList(ListNode head) {
		return sortList1(head).first;
	}
	// quick sort
	public Pair sortList1(ListNode head) {
		if(head==null||head.next==null) return new Pair(head, head);
		ListNode mid = getMid(head);//n
		ListNode dl= new ListNode(0),dr= new ListNode(0), dm= new ListNode(0);
		ListNode hl=dl,hr=dr,hm=dm;
		while(head!=null){
			if(head.val<mid.val){hl.next=head;hl=head;}
			else if(head.val>mid.val){hr.next=head;hr=head;}
			else{hm.next=head; hm=head;}
			head= head.next;
		}
		hl.next=hr.next=hm.next=null;Pair m = new Pair(dm.next, hm);
		Pair l= sortList1(dl.next),r= sortList1(dr.next);
		return concat(concat(l,m), r);
	}

	private Pair concat(Pair l, Pair r) {
		if(l.first!=null){l.second.next=r.first;
			if(r.first!=null){return new Pair(l.first, r.second);}
			else{return l;}
		}
		if(r.first!=null) return r;
		return new Pair(null, null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
