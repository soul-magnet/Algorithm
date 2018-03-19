package main.java.ladders.PermutationBasedDFS;

import java.util.ArrayList;
/**
 * 
 * 34. N-Queens II - Medium - Required
 * 
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Example
For n=4, there are 2 distinct solutions.

Tags: Recursion

Related Problems 
Medium Combinations 33 %
Medium N-Queens 25 %
 * */
public class NQueens2 {
	/**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
	
	 public static int sum;
	    public int totalNQueens(int n) {
	        sum = 0;
	        int[] usedColumns = new int[n];
	        placeQueen(usedColumns, 0);
	        return sum;
	    }
	    public void placeQueen(int[] usedColumns, int row) {
	        int n = usedColumns.length;
	        
	        if (row == n) {
	            sum ++;
	            return;
	        }
	        
	        for (int i = 0; i < n; i++) {
	            if (isValid(usedColumns, row, i)) {
	                usedColumns[row] = i;
	                placeQueen(usedColumns, row + 1);
	            }
	        }
	    }
	    public boolean isValid(int[] usedColumns, int row, int col) {
	        for (int i = 0; i < row; i++) {
	            if (usedColumns[i] == col) {
	                return false;
	            }
	            if ((row - i) == Math.abs(col-usedColumns[i])) {
	                return false;
	            }
	        }
	        return true;
	    }

}
