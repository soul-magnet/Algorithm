package HighFrequency;

import java.util.ArrayList;

/*
 * Given an array of integers, find the subarray with smallest sum.
 * Return the sum of the subarray.
 * Have you met this question in a real interview? Yes
 * Example
 * For [1, -1, -2, 1], return -3
 * Note:
 * The subarray should contain at least one integer.
 * */

public class MinimumSubarray {
	/**
    * @param nums: a list of integers
    * @return: A integer indicate the sum of minimum subarray
    */
	public int minSubArray(ArrayList<Integer> nums) {
		
		if (nums == null)
			return 0;
		int len = nums.size();
		int min = Integer.MAX_VALUE, currSum = 0;
		int []localMin = new int[len];
		int []globalMin = new int[len];
		
		for (int i = 0; i < len; i++){
			if(i == 0){
				globalMin[i] = localMin[i] = nums.get(i);
		} else {
			localMin[i] = Math.min(localMin[i -1] + nums.get(i), nums.get(i));
			globalMin[i] = Math.min(globalMin[i - 1], localMin[i]);
		}
	}
		return globalMin[len -1];
	}
}
