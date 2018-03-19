package main.java.ladders.DynamicProgramming;
/**
 * 191. Maximum Product Subarray - Medium 

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags 
Subarray LinkedIn Dynamic Programming
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
	public int maxProduct(int[] nums){
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		
		min[0] = max[0] = nums[0];
		int result = nums[0];
		for(int i = 1; i < nums.length; i++){
			min[i] = max[i] = nums[i];
			if(nums[i] > 0){
				max[i] = Math.max(max[i], max[i-1] * nums[i]);
				min[i] = Math.min(min[i], max[i -1] * nums[i]);
			}
			result = Math.max(result, max[i]);
		}
		return result;
	}
}
