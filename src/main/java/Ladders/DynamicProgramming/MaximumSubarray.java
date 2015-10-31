package DynamicProgramming;

import java.util.ArrayList;

/*
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * Example: Given the array [−2,2,−3,4,−1,2,1,−5,3], 
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Note: The subarray should contain at least one number.

Challenge
Can you do it in time complexity O(n)?

Analysis: localMax[i] = max(localMax[i-1]+ nums.get(i), nums.get(i))
		  globalMax[i] = max(globalMax[i-1], localMax[i]);

*/
public class MaximumSubarray {
	
	/**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
	
	public int maxSubArray(ArrayList<Integer> nums){
		if (nums.size() == 0)
			return 0;
		int n = nums.size();
		int []global = new int[n];
		int []local = new int[n];
		
		global[0] = nums.get(0);
		local[0] = nums.get(0);
		
		for (int i = 1; i < n; i++){
			local[i] = Math.max(nums.get(i), local[i -1] + nums.get(i));
			global[i] = Math.max(local[i], global[i-1]);
		}
		
		return global[n-1];
	}
	
	// version; Greedy
	
	public int maxSubArrayX(ArrayList<Integer> nums){
		if (nums == null || nums.size() == 0)
			return 0;
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < nums.size(); i++){
			sum += nums.get(i);
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}
	
	// Version : Prefix sum (DP)
	public int maxSubArrayY(ArrayList<Integer>nums){
		if (nums == null || nums.size() == 0)
			return 0;
		int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
		for (int i = 0; i < nums.size(); i++){
			sum += nums.get(i);
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
	
	
}
