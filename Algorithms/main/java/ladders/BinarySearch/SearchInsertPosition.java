package BinarySearch;
/*
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be 
 * if it were inserted in order.
 * You may assume NO duplicates in the array.
 * 
 * Example: [1,3,5,6], 5 → 2
 * 			[1,3,5,6], 2 → 1
 * 			[1,3,5,6], 7 → 4
 * 			[1,3,5,6], 0 → 0
 * 
 * Challenge: O(log(n)) time
 * 
 * Analysis: 
 * Solution 1: Naively, we can just iterate the array and compare
 * target with ith and (i + 1)th element. The complexity is O(n)
 * 
 * */
public class SearchInsertPosition {
	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        //Solution 1
    	/*if (A == null) return 0;
    	if (target <= A[0]) return 0;
    	
    	for (int i = 0; i < A.length - 1; i++){
    		if (target > A[i] && target <= A[i+1]){
    			return i+1;
    		}
    	}
    	
    	return A.length;*/
    	
    	// Solution 2: Binary Search, recursive
    	/*if (A == null || A.length == 0)
    		return 0;
    	return searchInsert(A, target, 0, A.length-1);
    }

	private int searchInsert(int[] A, int target, int start, int end) {
		int mid = (start + end) /2;
		
		if (target == A[mid])
			return mid;
		else if(target < A[mid])
			return start < mid ? searchInsert(A, target, start, mid-1) : start;
		else 
			return end > mid ? searchInsert(A, target, mid + 1, end):(end+1);
	}*/
	
	// Solution 3: Binary Search, find the first position >= target
    	if (A == null || A.length == 0){
    		return 0;
    	}
    	
    	int start = 0, end = A.length - 1;
    	while (start + 1 < end){
    		int mid = start + (end - start) / 2;
    		if (A[mid] == target){
    			return mid;
    		} else if (A[mid] < target){
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (A[start] >= target){
    		return start;
    	} else if (A[end] >= target){
    		return end;
    	} else {
    		return end + 1;
    	}
    	
    	// version 2: find the last position < target, return + 1
    	/*
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        
        if (target < A[0]) {
            return 0;
        }
        // find the last number less than target
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[end] == target) {
            return end;
        }
        if (A[end] < target) {
            return end + 1;
        }
        if (A[start] == target) {
            return start;
        }
        return start + 1;*/
    }
}


	