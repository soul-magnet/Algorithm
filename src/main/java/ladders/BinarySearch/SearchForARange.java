package main.java.ladders.BinarySearch;

import java.util.ArrayList;

/**
 * 61. Search for a Range - Medium -Optional

Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Example
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

Challenge 
O(log n) time.

Tags: Array Binary Search Sorted Array

Related Problems 
Medium Range Sum Query 2D - Immutable 21 %
Easy Total Occurrence of Target 27 %
 * */
public class SearchForARange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        int start = 0, end = A.size() - 1 , mid;
        int[] bound = new int[2];
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);
        if (A == null || A.size() == 0){
        	return result;
        }
        // search for left bound
        while (start + 1 < end){
        	mid = start + (end - start) / 2;
        	if (A.get(mid) < target){
        		
        		start = mid + 1;
        	} else if (A.get(mid) == target){
        		end = mid;
        	} else {
        		end = mid - 1;
        	}
        }
        
       if(A.get(start) == target){
    	   result.set(0, start);
       } else if (A.get(end) == target) {
    	   result.set(0, end);
       }
       
       // right border
       while (start + 1 <  end){
    	   mid = start + (end - start) / 2;
    	   if (A.get(mid) < target){
    		   start = mid + 1;
    	   } else if (A.get(mid) == target){
    		   start = mid;
    	   } else {
    		   end = mid - 1;
    	   }
       }
       if (A.get(end) == target) {
    	   result.set(1, end);
       } else if (A.get(start) == target){
    	   result.set(1, start);
       }
       
       return result;
    }
}
