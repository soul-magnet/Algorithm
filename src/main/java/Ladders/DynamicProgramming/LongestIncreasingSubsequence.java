package DynamicProgramming;
/*
 * Given a sequence of integers, find the longest increasing subsequence(LIS).
 * You code should return the length of the LIS.
 * Example: For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * 			For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 * Challenge: Time complexity O(n^2) or O(nlogn)
 * Clarification: What's the definition of longest increasing subsequence?
 * The longest increasing subsequence problem is 
 * to find a subsequence of a given sequence in which 
 * the subsequence's elements are in sorted order, 
 * lowest to highest, and in which the subsequence is as long as possible. 
 * This subsequence is not necessarily contiguous, or unique.  
 * 
 * Analysis: Dynamic Programming 
 * generate a temp array with the size of the original one 
 * keep two pointer i and j
 * arr[0] = i and arr[2] = j
 * 
 * if (arr[j] < arr[i]){
 * 		T[i] = max(T[i], T[j]+1)
 * }
 * 
 * */
public class LongestIncreasingSubsequence {
	/**
     * @param nums: an array of integers
     * @return: an integer
     */
	public int longestIncreasingSubsequence(int[] nums) {
        int []dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++){
        	dp[i] = 1;
        	for (int j = 0; j < i; j++){
        		if (nums[j] <= nums[i]){
        			dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
        			//dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	if(dp[i] > max)
        		max = dp[i];
        	//max = Math.max(max, dp[i]);
        }
        return max;
    }
}
