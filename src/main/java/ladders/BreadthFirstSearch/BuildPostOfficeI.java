package BreadthFirstSearch;

/**
 * 
 * 574. Build Post Office - Hard

Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), 
find the place to build a post office, the distance that post office to all the house sum is smallest. 
Return the smallest distance. Return -1 if it is not possible.

 Notice: You can pass through house and empty.
		 You only build post office on an empty.
		 

Example
Given a grid:

0 1 0 0
1 0 1 1
0 1 0 0
return 6. (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

Tags: Sort Binary Search

Related Problems 
Medium Nearest Exit 31 %
Hard Build Post Office II 27 %*/

public class BuildPostOfficeI {
	
	//Using Manhattan Distance
	public static int shortestDistance(int[][] grid) {
        // Write your code here
		int row = grid.length, column = grid[0].length;
		
		//corner case also includes if there is no space to build post office
		if(row == 0 || column == 0 || !haveZero(grid, row, column)) return -1;
		
		int[] rowSum = new int[row];
		int[] colSum = new int[column];
		
		//determinig houses(1s) in the grid
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(grid[i][j] == 1) {
					rowSum[i]++;
					colSum[j]++;
				}
			}
		}
		
		//prefixCost[i] = prefixCost[i - 1] + prefixSum[i - 1]
		//Sum of the houses to the ith row denoted as ansRow[i]
		//Sum of the houses to the jth column denoted as ansColumn[j]
		int[] ansRow = new int[row];
		int[] ansColumn = new int[column];
		
		//Manhattan distance from all the houses to the certain point = ansRow[i] + ansColumn[j];
		getSumDistance(rowSum, row, ansRow);
		getSumDistance(colSum, column, ansColumn);
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < column; j++) 
				if(grid[i][j] == 0 && ans > ansRow[i] + ansColumn[j]) 
					ans = ansRow[i] + ansColumn[j];
		
		System.out.println("ans" + ans);	
		return ans;
		
	}
	
	
	// to check if there is a space to build post office, 
	// otherwise everywhere is occupied by 1s as houses
	static boolean haveZero(int[][] grid, int row, int column) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(grid[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
	//find prefix sum
	static void getSumDistance(int[] axisSum, int n, int[] ans) {
		int[] prefixSum1 = new int[n]; // prefixSum1[i]=a[0]+a[1]+a[2]+...+a[i];
		int[] prefixSum2 = new int[n];
		
		/**
		 * First Stage
		 * */
		prefixSum1[0] = axisSum[0];
		for(int i = 1; i < n; i++) {
			prefixSum1[i] = prefixSum1[i - 1] + axisSum[i];
		}
		
		prefixSum2[0] = 0;
		for(int i = 1; i < n; i++) {
			prefixSum2[i] = prefixSum2[i-1] + prefixSum1[i - 1];
		}
		
		for(int i = 0; i < n; i++) {
			ans[i] = prefixSum2[i];
		}
		
		/**
		 * Second Stage: dealing with suffixes
		 * prefixSum1 records the suffix sum of array a, that is: prefixSum1[i]=a[n-1] + a[n-2]+...+a[i].
		 * prefixSum2 records the suffix sum prefixSum1 array
		 * */
		prefixSum1[n-1] = axisSum[n-1];
		for(int i = n - 2; i >= 0; i--) {
			prefixSum1[i] = prefixSum1[i+1] + axisSum[i];
		}
		
		prefixSum2[n - 1] = 0;
		for(int i = n - 2; i >= 0; i--) {
			prefixSum2[i] = prefixSum2[i + 1] + prefixSum1[i + 1];
		}
		
		//ans[i] is the sum of all the points in the a-point to ith point
		for(int i = 0; i < n; i++) {
			ans[i] += prefixSum2[i];
		}
	}
	
	public static void main(String args[]) {
		int[][] grid = {{0, 1, 0, 0},
						{1, 0, 1, 1},
						{0, 1, 0, 0}};
		
		shortestDistance(grid);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
