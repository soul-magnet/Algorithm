package main.java.ladders.Greedy;

import java.util.ArrayList;

/**
 * 44. Minimum Subarray - Easy

Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

 Notice
The subarray should contain one integer at least.

Example
For [1, -1, -2, 1], return -3.

Tags: LintCode Copyright Greedy Subarray Array

Related Problems 
Medium Maximum Product Subarray 30 %
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
	
	/////////////////////////////////////
    public int minSubArray(ArrayList<Integer> nums) {
        int sum=0, sumMax= 0, min = Integer.MAX_VALUE;
        for(int i = 0; i< nums.size(); i++){
            sum += nums.get(i);
            min= Math.min(min, sum-sumMax);
            sumMax = Math.max(sumMax, sum);
            
        }
        return min;
    }
}
