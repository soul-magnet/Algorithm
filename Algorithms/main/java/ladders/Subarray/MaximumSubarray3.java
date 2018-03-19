package main.java.ladders.Subarray;
/**
 * 43. Maximum Subarray III - Hard - Related Questions

Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

 Notice
The subarray should contain at least one number

Have you met this question in a real interview? 
Example
Given [-1,4,-2,3,-2,3], k=2, return 8

Tags 
Array Subarray LintCode Copyright Dynamic Programming
Related Problems 
Hard Maximum Subarray V 29 %
Medium Maximum Subarray IV 35 %
Medium Best Time to Buy and Sell Stock III 27 %
Medium Best Time to Buy and Sell Stock II 49 %
Medium Best Time to Buy and Sell Stock 40 %
Medium Maximum Subarray Difference 24 %
Hard Maximum Subarray III 25 %
Medium Maximum Subarray II 26 %
Easy Maximum Subarray 38 %
 * */
public class MaximumSubarray3 {
	/**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        if(k==0||nums==null){
			return 0;
		}
		int len= nums.length;
		int [][] local = new int[k+1][len+1];
		int [][] global = new int[k+1][len+1];
		for(int i =1; i<k+1;i++){
			local[i][i-1]=Integer.MIN_VALUE;//len must >=k to make at least 1 partition
			// if nums[j-1] to nums[len-1] are -negative nums, then the max sub is negative,
			// so to initialize local[i][i-1]=Integer.MIN_VALUE; 
			for(int j=i;j<len+1;j++){
			    local[i][j] = Math.max(local[i][j-1], global[i - 1][j-1]) + nums[j-1];
			    if(i==j){
			        global[i][j]=local[i][j];
			    }else{
				global[i][j]= Math.max(global[i][j-1],local[i][j]);
			    }
			 }
		}
		return global[k][len];
    }

}
