package main.java.ladders.DynamicProgramming;
/**
 * 513. Perfect Squares - Medium - Required

Given a positive integer n, find the least number of perfect square numbers 
(for example, 1, 4, 9, 16, ...) which sum to n.
 
Example
Given n = 12, return 3 because 12 = 4 + 4 + 4
Given n = 13, return 2 because 13 = 4 + 9

Tags: Mathematics Dynamic Programming

Related Problems 
Easy Check Sum of Square Numbers 15 %
Medium Ugly Number II 24 %
 * */
public class PerfectSquares {
	/**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
          int[] dp = new int[n + 1];
        for(int i=0; i<n+1; i++){
            dp[i]= Integer.MAX_VALUE;
        }
        for(int i=0; i*i<n+1;i++){
            dp[i*i]=1;
        }
        for(int i=0; i<n+1; i++){
            for ( int j=0; i+j*j<n+1;j++){
                dp[i+j*j]= Math.min(dp[i+j*j], dp[i]+1);
            }
        }
        return dp[n];
    }

}
