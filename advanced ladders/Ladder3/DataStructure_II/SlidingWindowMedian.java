package Ladder3.DataStructure_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 360. Sliding Window Median - Hard - Required
 
Given an array of n integer, and a moving window(size k), 
move the window at each iteration from the start of the array, 
find the median of the element inside the window at each moving. 
(If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )


Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;

Challenge 
O(nlog(n)) time

Tags: LintCode Copyright Heap

Related Problems 
Medium Sliding Window Unique Elements Sum 12 %
Easy Window Sum 33 %
Hard Paint House II 26 %
Super Building Outline 14 %
Super Sliding Window Maximum 27 %
Hard Data Stream Median 30 %*/

public class SlidingWindowMedian {
	
	private PriorityQueue<Integer> l, r; //max, min;
	private int len =0;
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	    ArrayList<Integer> res = new ArrayList<>();
		if(nums==null||k==0){
			return res;
		}
		l = new PriorityQueue<>(k, Collections.reverseOrder());
		r = new PriorityQueue<>();
		for(int i=0;i<nums.length; i++){
			if(i<k-1){
				addEle(nums[i],k);
				continue;
			}
			if(i==k-1){
				addEle(nums[i],k);
				res.add(l.peek());
				continue;
			}
			removeEle(nums[i-k], k);
			addEle(nums[i],k);
			res.add(l.peek());
		}
		return res;
	}

	private void removeEle(int i, int k) {
	if(i>l.peek()){
			r.remove(i);
		}else{
			l.remove(i);
		}len--;
		if(len%2==0){
			while(l.size()<len/2){
				l.add(r.poll());
			}
			while(l.size()>len/2){
				r.add(l.poll());
			}
		}else{
			while(l.size()<len/2+1){
				l.add(r.poll());
			}
			while(l.size()>len/2+1){
				r.add(l.poll());
			}
		}
	}

	private void addEle(int i, int k) {
		l.add(i);
			if(len%2==0){//not even
				if( r.isEmpty()){
					len++;
					return;
				}
				if(r.peek()<l.peek()){
					int right = r.poll();
					int left = l.poll();
					r.add(left);
					l.add(right);
				}
			}else{//even
				r.add(l.poll());
			}
		len++;
	}

}
