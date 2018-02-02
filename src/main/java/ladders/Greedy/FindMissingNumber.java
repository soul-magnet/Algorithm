package Greedy;

import java.util.Arrays;

/* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * For example: Given nums = [0, 1, 3] return 2.
 * Note: Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 * 
 * Analysis: 
 * 1. Bit Computing Method: XOR properties: Commutativity and Associativity
 * (A ^ B ^ C) ^ (A ^ B) = C
 * 
 * 2. Dichotomy: Find the first index and nums[index] is not the same
 * 
 * Summary: If the array is sorted, then the fastest is dichotomy.
 * Otherwise, use bit computing method. 
 * 
 * look at t this link as well : http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
 * 
 * */
public class FindMissingNumber {
	 /**    
     * @param nums: an array of integers
     * @return: an integer
     */
	
	public int findMissing(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int res = nums.length;
		for(int i = 0; i < nums.length; i++){
			res ^= i;
			res ^= nums[i];
		}
		
		return res;
	}
	
	public int findMissingII(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		Arrays.sort(nums);
		
		int start = 0;
		int end = nums.length;
		while (start < end){
			int mid = (start + end)/2;
			if (mid < nums[mid]){
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
