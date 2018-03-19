package main.java.ladders.BinarySearch;
/**
 * 160. Find Minimum in Rotated Sorted Array II - Medium - Optional

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 Notice
The array may contain duplicates.

Example
Given [4,4,5,6,7,0,1,2] return 0.

Tags 
Binary Search Divide and Conquer
Related Problems 
Medium Find Minimum in Rotated Sorted Array 39 %
Medium Search in Rotated Sorted Array II 40 %
 * 
 * */
/*
 * Analysis: 
 * This is a follow-up question. We only need to add one more condition, which checks
 * if the left-most element and the right most element are equal.  If they are equal we can simply 
 * drop one of them. 
 * */
public class FindMinimumInRotatedSortedArray2 {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int min = num[0];
        for (int i = 1; i < num.length; i++){
        	if (num[i] < min){
        		min = num[i];
        	}
        }
        
        return min;
    }
}
