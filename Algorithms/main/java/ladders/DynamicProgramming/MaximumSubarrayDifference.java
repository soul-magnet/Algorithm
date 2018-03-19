package main.java.ladders.DynamicProgramming;

import java.util.ArrayList;
/**
 * 45. Maximum Subarray Difference - Medium

Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

 Notice
The subarray should contain at least one number

Example
For [1, 2, -3, 1], return 6.

Challenge 
O(n) time and O(n) space.

Tags: Greedy Enumeration LintCode Copyright Array Subarray Forward-Backward Traversal

Related Problems 
Medium Maximum Product Subarray 30 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
 * */
/*
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, 
 * which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 * Example: For [1, 2, -3, 1], return 6
 * Note: The subarray should contain at least one number
 * Challenge: O(n) time and O(n) space.
 * 
 * Analysis: */
public class MaximumSubarrayDifference {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */ 
	
	public int maxDiffSubarrays(ArrayList<Integer> nums){
		if (nums == null || nums.size() == 0)
			return 0;
		
		int[] maxFromLeft = new int[nums.size()];
		int[] minFromLeft = new int[nums.size()];
		int min = nums.get(0);
		int max = min;
		int localmin = min;
		int localmax = max;
		
		maxFromLeft[0] = minFromLeft[0] = min;
		for (int i = 1; i < nums.size(); i++){
			localmin = Math.min(nums.get(i), localmin+nums.get(i));
			localmax = Math.max(nums.get(i), localmax+nums.get(i));
			max = Math.min(nums.get(i), localmin + nums.get(i));
			min = Math.min(min, localmin);
			maxFromLeft[i] = max;
			minFromLeft[i] = min;
		}
		
		min = nums.get(nums.size() - 1);
		max = min;
		localmin = min;
		localmax = max;
		
		int res = Math.max(max - minFromLeft[nums.size() - 2], maxFromLeft[nums.size() - 2] - min);
		for(int i = nums.size() - 2; i > 0; i--){
			localmin = Math.min(nums.get(i), localmin+nums.get(i));
			localmax = Math.max(nums.get(i), localmax+nums.get(i));
			max = Math.max(max, localmax);
			min = Math.min(min, localmin);
			res = Math.max(res, Math.max(max - minFromLeft[i-1], maxFromLeft[i-1] - min));
		}
		
		return res;
	}
	
	// Another solution
	 public int maxDiffSubArrays(ArrayList<Integer> nums) {
	        // write your code
	        int[] maxLeft = new int[nums.size()];
	        int[] minLeft = new int[nums.size()];
	        int[] maxRight = new int[nums.size()];
	        int[] minRight = new int[nums.size()];
	        
	        int leftMaxLocal, leftMinLocal, rightMaxLocal, rightMinLocal;
	        maxLeft[0] = leftMaxLocal = minLeft[0] = leftMinLocal = nums.get(0);
	        maxRight[nums.size() - 1] = rightMaxLocal = minRight[nums.size() - 1] = rightMinLocal = nums.get(nums.size() - 1);
	        
	        for (int i = 1; i < nums.size(); i++) {
	            //left
	            leftMaxLocal = Math.max(leftMaxLocal + nums.get(i), nums.get(i));
	            maxLeft[i] = Math.max(leftMaxLocal, maxLeft[i - 1]);
	            leftMinLocal = Math.min(leftMinLocal + nums.get(i), nums.get(i));
	            minLeft[i] = Math.min(leftMinLocal, minLeft[i - 1]);
	            //right
	            rightMaxLocal = Math.max(rightMaxLocal + nums.get(nums.size() - i - 1), nums.get(nums.size() - i - 1));
	            maxRight[nums.size() - i - 1] = Math.max(rightMaxLocal, maxRight[nums.size() - i]);
	            rightMinLocal = Math.min(rightMinLocal + nums.get(nums.size() - i - 1), nums.get(nums.size() - i - 1));
	            minRight[nums.size() - i - 1] = Math.min(rightMinLocal, minRight[nums.size() - i]);
	        }
	        
	        int maxDif = 0;
	        for (int i = 0; i < nums.size() - 1; i++) {
	            maxDif = Math.max(maxDif, Math.max(Math.abs(maxLeft[i] - minRight[i + 1]), Math.abs(minLeft[i] - maxRight[i + 1])));
	        }
	        return maxDif;
	    }
}
