package main.java.ladders.GraphSearch;

import java.util.ArrayList;
/**
 * 33. N-Queens - Medium - Required

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
both indicate a queen and an empty space respectively.

Example
There exist two distinct solutions to the 4-queens puzzle:

[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]
Challenge: Can you do it without recursion?

Tags: Recursion Depth First Search

Related Problems 
Medium Pacific Atlantic Water Flow 28 %
Medium Combinations 33 %
Medium N-Queens II 40 %
 * */
/*Analysis: classic recursive problem
* 1. Use a valid int vector to store the current state, A[i] = j refers that the ith row and
* jth column is placed a queen
* 2. Valid state: not tin the same column, which is A[i] != A[current], not in the
* same diagonal direction: abs(A[i]-A[current]) != r-i
* 3. Recursion: 
* Start: placeQueen(0, n)
* 	if (current == n then print result)
* 	else
* 		for each place less than n, 
* 			place queen
* 			if current state is valid, then place next queen placeQueen(cur+1, n)
* 		end for 
* 
*
*/
public class NQueens {
	/**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
	// Back-traacking approach
	// wrapper method
	ArrayList<ArrayList<String>> solveNQueens(int n){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (n <= 0) {
			return result;
		}
		search(n, new ArrayList<Integer>(), result);
		return result;
	}
	
	/*
	 * n : total rows / columns
	 * cols : <row : queen column position>
	 * result : <row : placement string>
	 * */
	private void search(int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> result) {
		if (cols.size() == n) {
			result.add(drawChessBoard(cols));
			return;
		}
		
		for (int col = 0; col < n; col++) {
			if (!isValid(cols, col)) {
				continue;
			}
			cols.add(col);
			search(n, cols, result);
			cols.remove(cols.size() - 1);
		}
	}
	
	private boolean isValid(ArrayList<Integer> cols, int col) {
		int row = cols.size();
		for (int i = 0; i < row; i++) {
			// same column
			if (cols.get(i) == col) {
				return false;
			}
			// left-top to the right-bottom
			if (i - cols.get(i) == row - col){
				return false;
			}
			
			// right-top to left bottom
			if(i + cols.get(i) == row + col){
				return false;
			}
		}
		
		return true;
	}
	
	private ArrayList<String> drawChessBoard(ArrayList<Integer> cols) {
		ArrayList<String> chessboard = new ArrayList<String>();
		for (int i = 0; i < cols.size(); i++){
			chessboard.add(i, "");
			for (int j = 0; j < cols.size(); j++){
				if (j == cols.get(i)){
					chessboard.set(i, chessboard.get(i) + "Q");
				} else {
					chessboard.set(i, chessboard.get(i) + ".");
				}
			}
		}
		return chessboard;
	}
	
}
