package Ladder5.DynamicProblem_I;
/**
 * 191. Maximum Product Subarray 

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags 
LinkedIn Subarray Dynamic Programming
Related Problems 
Medium Rogue Knight Sven 29 %
Medium Best Time to Buy and Sell Stock 41 %
Medium Maximum Subarray Difference 24 %
Easy Minimum Subarray 38 %
Medium Maximum Subarray II 26 %
 * 
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

}
//Juizhang Solution
//LeetCode version:
//public class Solution {
// /**
//  * @param nums: an array of integers
//  * @return: an integer
//  */
// public int maxProduct(List<Integer> nums) {
//     int[] max = new int[nums.size()];
//     int[] min = new int[nums.size()];
//     
//     min[0] = max[0] = nums.get(0);
//     int result = nums.get(0);
//     for (int i = 1; i < nums.size(); i++) {
//         min[i] = max[i] = nums.get(i);
//         if (nums.get(i) > 0) {
//             max[i] = Math.max(max[i], max[i - 1] * nums.get(i));
//             min[i] = Math.min(min[i], min[i - 1] * nums.get(i));
//         } else if (nums.get(i) < 0) {
//             max[i] = Math.max(max[i], min[i - 1] * nums.get(i));
//             min[i] = Math.min(min[i], max[i - 1] * nums.get(i));
//         }
//         
//         result = Math.max(result, max[i]);
//     }
//     
//     return result;
// }
//}
//
////LintCode Version 1:
//public class Solution {
// /**
//  * @param nums: an array of integers
//  * @return: an integer
//  */
// public int maxProduct(int[] nums) {
//     int[] max = new int[nums.length];
//     int[] min = new int[nums.length];
//     
//     min[0] = max[0] = nums[0];
//     int result = nums[0];
//     for (int i = 1; i < nums.length; i++) {
//         min[i] = max[i] = nums[i];
//         if (nums[i] > 0) {
//             max[i] = Math.max(max[i], max[i - 1] * nums[i]);
//             min[i] = Math.min(min[i], min[i - 1] * nums[i]);
//         } else if (nums[i] < 0) {
//             max[i] = Math.max(max[i], min[i - 1] * nums[i]);
//             min[i] = Math.min(min[i], max[i - 1] * nums[i]);
//         }
//         
//         result = Math.max(result, max[i]);
//     }
//     
//     return result;
// }
//}
//
////LintCode version2: O(1) Space Complexity
//public class Solution {
// /**
//  * @param nums: an array of integers
//  * @return: an integer
//  */
// public int maxProduct(int[] nums) {
//     // write your code here
//     if (nums == null || nums.length == 0) {
//         return 0;
//     }
//     int minPre = nums[0], maxPre = nums[0];
//     int max = nums[0], min = nums[0];
//     int res = nums[0];
//     for (int i = 1; i < nums.length; i ++) {
//         max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
//         min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
//         res = Math.max(res, max);
//         maxPre = max;
//         minPre = min;
//     }
//     return res;
// }
//}