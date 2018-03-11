package Ladders;

import java.util.ArrayList;

public class SearchForARange {
	
	/** 
	 * 
	 * Given a sorted array of n integers, find the starting and ending position of a given target value.

	If the target is not found in the array, return [-1, -1].

	
	Example
	Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

	Challenge
	O(log n) time.
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        int start, end, mid;
        ArrayList<Integer> bound = new ArrayList<Integer>();
        int index = 0;
        // search for left bound
        start = 0;
        end = A.size() - 1;
        mid = 0;
        if (A == null || A.size() == 0) {
            bound.add(index, -1);
            bound.add(index, -1);
            return bound;
        }
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
                
            }
        }
        if (A.get(start) == target) {
           bound.add(0,start);
        } else if (A.get(end) == target) {
           bound.add(0,end);
        } else {
       	    bound.add(0, -1);  bound.add(1, -1);
        return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.size() - 1;
        mid = 0;
        while (start + 1 < end){
            mid = (end - start) / 2 + start;
            if (A.get(mid) == target) {
                start = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(end) == target) {
           bound.add(1, end);
        } else if (A.get(start) == target) {
           bound.add(1, start);
        } else {
           bound.add(0, -1);  bound.add(1, -1);
           return (ArrayList<Integer>) bound;
       }
       
       return  bound;
    }

}
