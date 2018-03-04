package main.java.ladders.BinarySearch;
/**
 * 457. Classical Binary Search - Easy - Related

Find any position of a target number in a sorted array. Return -1 if target does not exist.

Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 1 or 2.

For target = 5, return 4 or 5.

For target = 6, return -1.

Challenge 
O(logn) time

Tags :Binary Search
Related Problems 
Easy Closest Number in Sorted Array 35 %
Easy Last Position of Target 36 %
Easy First Position of Target 33 %
 * */
/*
 * For a given sorted array (ascending order) and a target number, 
 * find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * Example: If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * Challenge: If the count of numbers is bigger than 2^32, can your code work properly?
 * */
public class BinarySearch {
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0){
        	return -1;
        }
        int start = 0;
        int end  = nums.length - 1;
        int mid = start + (end - start) / 2;
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[mid] == target){
        		end = mid;
        	} else if (nums[mid] < target) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        
        if (nums[start] == target){
        	return start;
        }
        
        if (nums[end] == target){
        	return end;
        }
        
        return -1;
    }
}
