package BreadthFirstSearch;

public class BuildPostOfficeI {
	
	public int shortestDistance(int[][] grid) {
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
		//Manhattan distance from all the houses to the certain point = ansRow[i] + ansColumn[j];
		
		int[] ansRow = new int[row];
		int[] ansColumn = new int[column];
		getSumDistance(rowSum, row, ansRow);
		getSumDistance(colSum, column, ansColumn);
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < column; j++) 
				if(grid[i][j] == 0 && ans > ansRow[i] + ansColumn[j]) 
					ans = ansRow[i] + ansColumn[j];
				
		return ans;
	}
	
	
	// to check if there is a space to build post office, 
	// otherwise everywhere is occupied by 1s as houses
	boolean haveZero(int[][] grid, int row, int column) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(grid[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
	//find prefix sums
	void getSumDistance(int[] a, int n, int[] ans) {
		int[] prefixSum1 = new int[n]; // prefixSum1[i]=a[0]+a[1]+a[2]+...+a[i];
		int[] prefixSum2 = new int[n];
		
		/**
		 * First Stage
		 * */
		prefixSum1[0] = a[0];
		for(int i = 1; i < n; i++) {
			prefixSum1[i] = prefixSum1[i - 1] + a[i];
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
		prefixSum1[n-1] = a[n-1];
		for(int i = n - 2; i >= 0; i--) {
			prefixSum1[i] = prefixSum1[i+1] + a[i];
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
