package main.java.ladders.HashTable;

import java.util.HashMap;

/**
 * 56. Two Sum - Easy

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are zero-based.

 Notice
You may assume that each input would have exactly one solution

Example
numbers=[2, 7, 11, 15], target=9

return [0, 1]

Challenge 
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
Tags: Sort Hash Table Airbnb Array Facebook Two Pointers

Related Problems 
Medium Two Sum - BST edtion 27 %
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Medium Two Sum - Greater than target 38 %
Medium Triangle Count 32 %
Medium 3Sum Closest 31 %
Medium 4Sum 22 %
Medium 3Sum 20 %
 * */
public class TwoSum {
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
       	if(numbers == null || numbers.length < 2) {
	    		return null;
	    	}
	        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
	        for(int i=0; i<numbers.length; i++){
	            hs.put(numbers[i], i+1);
	        }       
	        
	        int[] a = new int[2];
	        
	        for(int i=0; i<numbers.length ; i++){
	            if ( hs.containsKey( target - numbers[i] )){
	                int index1 = i+1;
	                int index2 = hs.get(target - numbers[i]);
	                if (index1 == index2){
	                    continue;
	                }
	                a[0] = index1;
	                a[1] = index2;
	                return a;
	            }
	        }
	        return a;
    }

}
