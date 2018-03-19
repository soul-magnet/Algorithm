package main.java.ladders.DynamicProgramming;
/**
 * 110. Minimum Path Sum - Easy - Required

Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Notice
You can only move either down or right at any point in time.

Tags: Dynamic Programming

Related Problems 
Easy Triangle 26 %
Medium Binary Tree Maximum Path Sum 25 %
 * */
public class MinimumPathSum {
	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
    	 if (grid == null || grid.length == 0 || grid[0].length == 0) {
             return 0;
         }

         int M = grid.length;
         int N = grid[0].length;
         int[][] sum = new int[M][N];

         sum[0][0] = grid[0][0];

         for (int i = 1; i < M; i++) {
             sum[i][0] = sum[i - 1][0] + grid[i][0];
         }

         for (int i = 1; i < N; i++) {
             sum[0][i] = sum[0][i - 1] + grid[0][i];
         }

         for (int i = 1; i < M; i++) {
             for (int j = 1; j < N; j++) {
                 sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
             }
         }

         return sum[M - 1][N - 1];
    }
}
