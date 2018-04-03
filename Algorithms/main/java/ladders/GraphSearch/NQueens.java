package main.java.ladders.GraphSearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 33. N-Queens - Medium - Required(LintCode)
 * 51. N-Queens - Medium (LeetCode)

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

Related Problems: 
Medium Pacific Atlantic Water Flow 28 %
Medium Combinations 33 %
Medium N-Queens II 40 %
 * */

/*Analysis: Two queens cannot attack each-other only if both are not sharing the same row, same column, and same diagonal lane
Use recursive DFS backtracking approach - Find out if the square is under attack or not
------------------------------------------------------------------------------------------------
For the N = 4 the board 4x4, but the index starts from 0
if the queen is placed on (1, 2) then all the rows and columns shared with the queen is under attack

row -> (1, 0), (1, 1), (1, 3)
col -> (0, 2), (2, 2), (3, 2)

How to find Diagonal attacks? 
From top left to bottom right: (row - col) -> 1-2 = -1 -> (0, 1), (2, 3)
From top right to bottom left: (row + col) -> 1+2 = 3 -> (3, 0), (2, 1), (0, 3)

So, these are the squares that the queen placed on (1,2) can attack.
--------------------------------------------------------------------------------------------------
Step 1:  Since the board is NxN the recursion will be N level deep.(In the example it's 4x4 board, 4 level deep recursion)
Place the 1st queen on the (0,0) increment the row and see what is the fist point we can place the 2nd queen,
which the 1st queen cannot attack
--------------------------------------------------------------------------------------------------
Step 2: increment the row and process the same. If you reach at the end of the column, 
then backtrack to the previous row again and see where else we can place the second queen
---------------------------------------------------------------------------------------------------
Step 4: Final result will be the placing all the N number of queens till reach the nxn board 
--------------------------------------------------------------------------------------------------
Time Complexity is Exponential(worst case) - because of backtracking and going back and forth
Space Complexity is O(n) - recursion in the worst case will be N level deep for an NxN board
--------------------------------------------------------------------------------------------------
References:
https://www.youtube.com/watch?v=xouin83ebxE&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh&index=2
https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/NQueenProblem.java

*
*/

//TODO However, I suggest that let’s use 3 boolean arrays instead. Let’s compare the run time:
//HashSet: 15ms, beats 17.85%
//Boolean Array: 5ms, beats 91.44%

public class NQueens {
	 /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
	//Recursive Backtracking
	private Set<Integer> col = new HashSet<Integer>();
	private Set<Integer> diag1 = new HashSet<Integer>();
	private Set<Integer> diag2 = new HashSet<Integer>();
	
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	dfs(result, new ArrayList<String>(), 0, n);
    	return result;
    }
    
    private void dfs(List<List<String>>result, List<String> tempList, int row, int n) {
    	if(row == n) {
    		result.add(new ArrayList<String>(tempList));
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		if(col.contains(i) || diag1.contains(row+i) || diag2.contains(row - i)) continue;
    		char[] charArray = new char[n];
    		Arrays.fill(charArray, '.');
    		charArray[i] = 'Q';
    		String rowString = new String(charArray);
    		
    		tempList.add(rowString);
    		col.add(i);
    		diag1.add(row+i);
    		diag2.add(row - i);
    		
    		dfs(result, tempList, row + 1, n);
    		tempList.remove(tempList.size() -1);
    		col.remove(i);
    		diag1.remove(row + i);
    		diag2.remove(row - i);
    	}
    }

}
