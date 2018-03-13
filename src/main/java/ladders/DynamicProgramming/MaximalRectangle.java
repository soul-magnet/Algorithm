package main.java.ladders.DynamicProgramming;

import java.util.Stack;

/**
 * 510. Maximal Rectangle - Hard

Given a 2D boolean matrix filled with False and True, 
find the largest rectangle containing all True and return its area.
 
Example
Given a matrix:

[
  [1, 1, 0, 0, 1],
  [0, 1, 0, 0, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1]
]
return 6.

Tags: Stack Array Dynamic Programming

Related Problems 
Medium Maximal Square 30 %
Hard Largest Rectangle in Histogram 28 %
 * */
public class MaximalRectangle {
	 public int maximalRectangle(char[][] matrix) {
	        if (matrix.length < 1) return 0;
	        int n = matrix.length;
	        if (n == 0) return 0;
	        int m = matrix[0].length;
	        if (m == 0) return 0;
	        int[][] height = new int[n][m];

	        for (int i = 0; i < n; ++i) {
	            for (int j = 0; j < m; ++j) {
	                if (i == 0)
	                    height[i][j] = ((matrix[i][j] == '1') ? 1 : 0);
	                else
	                    height[i][j] += ((matrix[i][j] == '1') ? height[i-1][j] + 1 : 0);
	            }
	        }

	        int answer = 0;
	        for (int i = 0; i < n; ++i) {
	            Stack<Integer> S = new Stack<Integer>();  
	            for (int j = 0; j < m; j++) {
	                while (!S.empty() && height[i][j] < height[i][S.peek()]) {
	                    int pos = S.peek();
	                    S.pop();
	                    answer = Math.max(answer, height[i][pos]*(S.empty()? j : j-S.peek()-1));
	                }
	                S.push(j);
	            }
	            while (!S.empty()) {
	                int pos = S.peek();
	                S.pop();
	                answer = Math.max(answer, height[i][pos]*(S.empty()? m : m-S.peek()-1));
	            }
	        }
	        return answer;
	    }
}
