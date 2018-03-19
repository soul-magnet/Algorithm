package main.java.ladders.BinarySearch;
/**
 * 
 * 447. Search in a Big Sorted Array - Medium - Required

Given a big sorted array with positive integers sorted by ascending order. 
The array is so big so that you can not get the length of the whole array directly, 
and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). 
Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.

 Notice
If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.

Example
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.

Challenge 
O(log k), k is the first index of the given target number.

Tags: Binary Search Sorted Array

Related Problems 
Easy First Position of Target 33 %
 * 
 * */
public class SearchInABigSortedArray {
	public int searchBigSortedArray(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int end = 0;
		while (end < A.length && A[end] < target){
			end = end * 2 + 1;
		}
		// find the first index of target
		int start = 0;
		while(start + 1 < end){
			int mid  = start + (end - start) /2;
			if (A[mid] == target){
				end = mid;
			} else if (A[mid] < target){
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (A[start] == target){
			return start;
		}
		if (A[end] == target){
			return end;
		}
		
		return -1;
	}

}
