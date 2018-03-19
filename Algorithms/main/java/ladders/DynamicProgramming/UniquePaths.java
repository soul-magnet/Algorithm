package main.java.ladders.DynamicProgramming;
/**
 * 114. Unique Paths - Easy - Required

A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?

 Notice
m and n will be at most 100.

Have you met this question in a real interview? 
Example
Given m = 3 and n = 3, return 6.
Given m = 4 and n = 5, return 35.

Tags 
Array Dynamic Programming
Related Problems 
Hard Unique Paths III 21 %
 * */

public class UniquePaths {
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
    	if (m == 0|| n == 0)
    		return 0;
    	int[][] dp = new int[n][m];
    	
    	for (int i = 0; i < m; i++)
    		dp[i][0] = 1;
    	
    	for (int i = 0; i < n; i++)
    		dp[0][i] = 1;
    		
    	for (int i = 1; i< m; i++){
    		for (int j = 1; j < n; j++){
    			dp[i][j] = dp[i-1][j] + dp[i][j-1];
    		}
    	}
 
    	return dp[m-1][n-1];
    }

}
