package main.java.ladders.BinarySearch;

import java.util.Arrays;

/**
 * 183. Wood Cut - Hard - Related

Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

 Notice
You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

Have you met this question in a real interview? 
Example
For L=[232, 124, 456], k=7, return 114.

Challenge 
O(n log Len), where Len is the longest length of the wood.

Tags 
Binary Search
 * */
public class WoodCut {
	/** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
	
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) {
			return 0;
		}
		
		int result = 0;
		Arrays.sort(L);
		int left = 1;
		int right = L[L.length - 1];
		while (left <= right){
			int mid = left + (right - left) / 2;
			if (numPieces(mid, L) < k){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	} 
	
	private int numPieces(int len, int[] L){
		int result = 0;
		for (int i = 0; i < L.length; i++){
			result += L[i] / len;
		}
		return result;
	}
     
}
