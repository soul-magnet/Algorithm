package main.java.ladders.LinkedList;
/**
 * 45. Maximum Subarray Difference - Medium - Related

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
public class MaximumSubarrayDifference {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        int len = nums.length;
        int [] lmax = new int[len];
        int [] rmin = new int[len];
        int [] lmin = new int[len];
        int [] rmax = new int[len] ;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i=0; i < nums.length; i++ ){
            sum += nums[i];
            max = Math.max(max, sum-minSum);
            minSum= Math.min(minSum, sum);
            lmax[i]=max;
        }

        int min = Integer.MAX_VALUE;
            sum = 0;
        int maxSum = 0;
        for (int i=0; i < nums.length; i++ ){
            sum += nums[i];
            min = Math.min(min, sum-maxSum);
            maxSum= Math.max(maxSum, sum);
            lmin[i]=min;
        }

         max = Integer.MIN_VALUE;
         sum = 0;
         minSum = 0;
        for (int i=nums.length-1; i >-1; i-- ){
            sum += nums[i];
            max = Math.max(max, sum-minSum);
            minSum= Math.min(minSum, sum);
            rmax[i]=max;
        }

        min = Integer.MAX_VALUE;
        sum = 0;
        maxSum = 0;
        for (int i=nums.length-1; i >-1; i-- ){
            sum += nums[i];
            min = Math.min(min, sum-maxSum);
            maxSum= Math.max(maxSum, sum);
            rmin[i]=min;
        }
        int diff= 0;
        for (int i=0; i < nums.length-1; i++ ){
            diff = Math.max(diff, Math.abs(lmax[i]-rmin[i+1]));
            diff = Math.max(diff, Math.abs(lmin[i]-rmax[i+1]));
        }
        return diff;
    }

}
