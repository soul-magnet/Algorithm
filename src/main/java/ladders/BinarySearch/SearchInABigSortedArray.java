package BinarySearch;
/* Given a big sorted array, find the first index of a target number. 
 * Your algorithm should be in O(log k), where k is the first index 
 * of the target number.
 * Return -1, if the number doesn't exist in the array.
 * Example: Given [1, 3, 6, 9, 21], and target = 3, return 1.
 * Given [1, 3, 6, 9, 21], and target = 4, return -1.
 * Challenge: O(log k), k is the first index of the given target number.
 * 
 * Analysis: Binary Search, because when there are duplicate numbers, 
 * return to the first occurrence of the index*/
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
