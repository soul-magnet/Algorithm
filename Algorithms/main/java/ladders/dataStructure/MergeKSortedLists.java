package main.java.ladders.dataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 
 * 104. Merge k Sorted Lists - Medium

Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

Tags: Twitter LinkedIn Linked List Airbnb Facebook Priority Queue Divide and Conquer Heap Uber Google
Related Problems 
Medium Merge Number 35 %
Medium Merge k Sorted Arrays 27 %
Easy Merge Two Sorted Arrays 35 %
Medium Ugly Number II 24 %
 * */
/* Analysis:
 * The simplest solution is using PriorityQueue. 
 * The elements of the priority queue are ordered according to their natural ordering,
 * or by a comparator provided at the construction time(in this case)
 * 
 * SOLUTION 1:
 * Use divide and conquer. Left and right respectively recursive call Merge K sorted List, 
 * and then use the merge linked list combined.
 * Answers are summarized as follows: This question is very common in distributed systems, 
 * sorted list from different client to merge together at the top central server. 
 * There are two general approaches this topic, following introduced one by one and analyze complexity. 
 * The first approach is easier to think, is a bit like MergeSort the idea is to divide and conquer, 
 * is a more classic O (nlogn) sorting algorithms, it is quite important. 
 * The idea is first divided into two sub-tasks, and then recursively Praying task, 
 * and finally back to come back. This topic is the case, first of k list in half, 
 * and then continue to divide, to know the remaining two on the list combined, 
 * will be used when merging Merge Two Sorted Lists 
 * 
 * SOLUTION 2:Next we look at the second method. This method uses a stack data structure, 
 * the idea is more difficult to imagine, but in fact the principle is simple. 
 * Maintain a heap of size k, each taking the smallest element of the stack into the top results, 
 * then read the next element of the element into the heap, re safeguard. 
 * Because each list is ordered, each is currently k to the smallest elements, 
 * so when the end of all the lists are read, 
 * this time all the elements from small to large in the results list. 
 * The algorithm for each element to be read once, that is, k * n times, 
 * then read each element should insert a new element to logk complexity of the heap, 
 * so the total time complexity is O (nklogk). 
 * Space complexity is the size of the heap, is O (k). Code is as follows: 
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
public class MergeKSortedLists {
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode>lists){
		if (lists.size() == 0 || lists == null){
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
	
	// PriorityQueue(Heap) Solution 
	// Time: log(k) * n.
	// k is number of list and n is number of total elements.
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0)
			return null;
 
		//PriorityQueue is a sorted queue
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
 
		//add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}
 
		ListNode head = new ListNode(0);
		ListNode p = head; // serve as a pointer/cursor
 
		while (q.size() > 0) {
			ListNode temp = q.poll();
			//poll() retrieves and removes the head of the queue - q. 
			p.next = temp;
 
			//keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);
 
			p = p.next;
		}
 
		return head.next;
	}
}
