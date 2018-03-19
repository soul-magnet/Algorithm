package main.java.ladders.Subarray;

import java.util.ArrayList;

/**
 * 191. Maximum Product Subarray - Medium - Related(LintCode) 
 * 152. Maximum Product Subarray  -Medium - (LeetCode)

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags: Subarray Dynamic Programming LinkedIn

Related Problems 
Medium Rogue Knight Sven 31 %
Medium Best Time to Buy and Sell Stock 40 %
Medium Maximum Subarray Difference 24 %
Easy Minimum Subarray 37 %
Medium Maximum Subarray II 26 %
 * */
public class MaximumProductSubarray {
	 /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		min[0] = max[0] = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min[i] = max[i] = nums[i];
			if (nums[i] > 0) {
				max[i] = Math.max(max[i], max[i - 1] * nums[i]);
				min[i] = Math.min(min[i], min[i - 1] * nums[i]);
			} else if (nums[i] < 0) {
				max[i] = Math.max(max[i], min[i - 1] * nums[i]);
				min[i] = Math.min(min[i], max[i - 1] * nums[i]);
			}

			result = Math.max(result, max[i]);
		}

		return result;
	}
    
    //MS OTS Variation: Return the maximum product subarray itself
    public int[] maxPro(int[] nums){
    	int[] result = new int[nums.length];
    	
    	if(nums == null || nums.length == 0) return result;
    	
    	//imax/imin stores the max/min product of subarray that ends with the current number nums[i]
    	int imax = nums[0], imin = nums[0], res = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		int temp = imax;
    		imax = Math.max(Math.max(imax * nums[i], imin * nums[i]), nums[i]);
    		imin = Math.min(Math.min(temp * nums[i], imin * nums[i]), nums[i]);
    		
    		if(imax > res) {
    			res = imax;
    			result[i] = nums[i]; // double check here
    		}
    	}
    	return result;
    	
    }

}
