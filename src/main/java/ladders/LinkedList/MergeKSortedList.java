package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * Given lists:
[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

* Analysis:
* 
* Use divide and conquer. Left and right respectively recursive call Merge K 
* sorted list, and then use the merge linked list combined.
* This question is very common in distributed systems, sorted list from 
* different client to merge together at the top central server. 
* There are two general approaches this topic, following introduced one by one 
* and analyze the complexity. 
* 
* Solution 1: 
* The first approach is easier to think, is a bit like MergeSort the idea 
* is to divide and conquer. O(nlogn) sorting algorithms, it's quite important.
* The idea is first divide two sub-task, and recursively Praying task, and
* finally back to come back. T
* 
* Solution 2: 
* This method uses a stack data structure, the idea is more difficult 
* to imagine but in fact the principle is simple.
* Maintain a heap of size k, each taking the smallest element of the stack 
* into the top results, then read the next element of the element into the heap,
* Because each list is ordered, each is currently k to the smallest elements,
* so when the end of the lists are read, this time all the elements from small
* to large in the results list. 
* The algorithm for each element to be rad once, that is, k * n times, 
* then read each element should insert a new element to logk complexity
* of the heap. so the total time complexity is O(nlogk). Space complexity 
* is the size of the heap, is O(k)
* */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class MergeKSortedList {
	// Solution 1
	public ListNode mergeKList(List<ListNode>lists){
		if (lists.size() == 0){
			return null;
		}
		return mergeHelper(lists,0, lists.size() - 1);
	}

	private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
		if (start == end)
			return lists.get(start);
		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);
		return mergeTwoLists(left, right);
	}

	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (list1 != null && list2 != null){
			if (list1.val < list2.val){
				tail.next = list1;
				tail = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				tail = list2;
				list2 = list2.next;
			}
		}
		if (list1 != null){
			tail.next = list1;
		} else {
			tail.next = list2;
		}
		
		return dummy.next;
	}
	
	// Solution 2: Heap
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
		public int compare(ListNode left, ListNode right){
			if (left == null){
				return 1;
			} else if (right == null){
				return -1;
			}
			return left.val - right.val;
		}
	};
	
	public ListNode mergeKLists2(ArrayList<ListNode> lists){
		if (lists == null || lists.size() == 0){
			return null;
		}
		
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		for (int i = 0; i < lists.size(); i++){
			if (lists.get(i) != null){
				heap.add(lists.get(i));
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()){
			ListNode head = heap.poll();
			tail.next = head;
			tail  = head;
			if (head.next != null){
				heap.add(head.next);
			}
		}
		return dummy.next;
	}
	
	// version 3: merge two by two 
	public ListNode mergeKLists3(List<ListNode>lists){
		if (lists == null || lists.size() == 0){
			return null;
		}
		
		while (lists.size() > 1){
			List<ListNode> newList = new ArrayList<ListNode>();
			for (int i = 0; i + 1 < lists.size(); i+= 2){
				ListNode mergedList = merge(lists.get(i), lists.get(i + 1));
				newList.add(mergedList);
			}
			if (lists.size() %2 == 1){
				newList.add(lists.get(lists.size() -1));
			}
			lists = newList;
		}
		return lists.get(0);
	}

	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(a != null && b != null){
			if (a.val < b.val){
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		if (a != null){
			tail.next = a;
		} else {
			tail.next = b;
		}
		return dummy.next;
	}

}
