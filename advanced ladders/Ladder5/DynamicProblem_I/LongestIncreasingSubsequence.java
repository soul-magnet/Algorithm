package Ladder5.DynamicProblem_I;
/**
 * 76. Longest Increasing Subsequence - Medium - Required

Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Clarification
What's the definition of longest increasing subsequence?

The longest increasing subsequence problem is to find a subsequence of a given sequence 
in which the subsequence's elements are in sorted order, lowest to highest, 
and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

Challenge 
Time complexity O(n^2) or O(nlogn)

Tags:LintCode Copyright Binary Search Dynamic Programming

Related Problems 
Hard Russian Doll Envelopes 19 %
Medium Largest Divisible Subset 35 %
Hard Frog Jump 30 %
 * */
public class LongestIncreasingSubsequence {
	 /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        	// f[i]= {max(f[i], f[j]+1), if(nums[j] <= nums[i]&&j<i)}
		// max= max{max, nums[i]}

         int f[]= new int [nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }

}

//Juizhang Solution
//public class Solution {
//    /**
//     * @param nums: The integer array
//     * @return: The length of LIS (longest increasing subsequence)
//     */
//   
//    
//    public int longestIncreasingSubsequence(int[] nums) {
//        int []f = new int[nums.length];
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            f[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
//                }
//            }
//            if (f[i] > max) {
//                max = f[i];
//            }
//        }
//        return max;
//    }
//}
//
//
//// O(nlogn) Binary Search
//public class Solution {
//    /**
//     * @param nums: The integer array
//     * @return: The length of LIS (longest increasing subsequence)
//     */
//    public int longestIncreasingSubsequence(int[] nums) {
//        int[] minLast = new int[nums.length + 1];
//        minLast[0] = Integer.MIN_VALUE;
//        for (int i = 1; i <= nums.length; i++) {
//            minLast[i] = Integer.MAX_VALUE;
//        }
//        
//        for (int i = 0; i < nums.length; i++) {
//            // find the first number in minLast >= nums[i]
//            int index = binarySearch(minLast, nums[i]);
//            minLast[index] = nums[i];
//        }
//        
//        for (int i = nums.length; i >= 1; i--) {
//            if (minLast[i] != Integer.MAX_VALUE) {
//                return i;
//            }
//        }
//        
//        return 0;
//    }
//    
//    // find the first number > num
//    private int binarySearch(int[] minLast, int num) {
//        int start = 0, end = minLast.length - 1;
//        while (start + 1 < end) {
//            int mid = (end - start) / 2 + start;
//            if (minLast[mid] < num) {
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
//        
//        return end;
//    }
//}
