package main.java.ladders.DynamicProgramming;

import java.util.ArrayList;
/**
 * 43. Maximum Subarray III - Hard

Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

 Notice
The subarray should contain at least one number

Example
Given [-1,4,-2,3,-2,3], k=2, return 8

Tags: LintCode Copyright Subarray Array Dynamic Programming

Related Problems 
Hard Maximum Subarray V 30 %
Medium Maximum Subarray IV 35 %
Medium Best Time to Buy and Sell Stock III 27 %
Medium Best Time to Buy and Sell Stock II 49 %
Medium Best Time to Buy and Sell Stock 40 %
Medium Maximum Subarray Difference 24 %
Hard Maximum Subarray III 25 %
Medium Maximum Subarray II 26 %
Easy Maximum Subarray 38 %
 * */
public class MaximumSubarrayIII {
	/**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
	
	public int maxSubArray(ArrayList<Integer>nums, int k){
		if (nums == null || nums.size() < k)
			return 0;
		int store[][] = new int[nums.size()+1][k+1];
		for (int subArray = 1; subArray <= k; subArray++){
			for (int i = subArray; i <= nums.size(); i++){
				long maxSum = Integer.MIN_VALUE;
				long localSum = 0;
				store[i][subArray] = Integer.MIN_VALUE;
				for (int j = i -1; j >= subArray - 1; j--){
					localSum = Math.max(nums.get(j), localSum + nums.get(j));
					store[i][subArray] = (int)Math.max(store[j][subArray - 1]+maxSum,
							store[i][subArray]);
				}
			}
		}
		return store[nums.size()][k];
	}
	// jiuzhang solution
	
	public static int maxSubArray3(ArrayList<Integer> nums, int k) {
        // write your code
        int len = nums.size();
        int[][] f = new int[k+1][len];
        for (int i = 1; i < k+1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums.get(j);
            }
            f[i][i-1] = sum;
        }
        for (int i = 1; i < len; i++) {
        	f[1][i] = Math.max(f[1][i-1]+nums.get(i), nums.get(i));
        }
        
        for (int i = 2; i < k+1; i++) {
            for (int n = i;  n< len; n++) {
                int curMax = f[i][n-1] + nums.get(n);
                for (int j = i-2; j < n; j++) {
                    if ((f[i-1][j] + nums.get(n)) > curMax) {
                        curMax = f[i-1][j] + nums.get(n);
                    }
                }
                f[i][n] = curMax;
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = k-1; i < len; i++){
            if (f[k][i] > res) {
                res = f[k][i];
            }
        }
        return res;
    }
}
