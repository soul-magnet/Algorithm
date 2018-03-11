package main.java.ladders.HashTable;
/**
 * 608. Two Sum - Input array is sorted - Medium

Given an array of integers that is already sorted in ascending order, find two numbers such that 
they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers 
(both index1 and index2) are not zero-based.

 Notice
You may assume that each input would have exactly one solution.

Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]

Tags: Hash Table Array Two Pointers Amazon

Related Problems 
Medium Two Sum - BST edtion 27 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
 * */
public class TwoSumInoutArrayIsSorted {
	/*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        		int res []= new int[2];
		if(nums==null||nums.length<2)return res;
		int l=0, r=nums.length-1;
		while(l<r){
			if(nums[l]+nums[r]==target){
				res[0]= l+1;
				res[1]= r+1;
				return res;
			}else if(nums[l]+nums[r]<target){
				l++;
			}else{
				r--;
			}
		}
		return res;
    }

}
