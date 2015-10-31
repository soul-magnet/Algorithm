package Ladders;

import java.util.ArrayList;

public class TrianglePathSum {

	private int DFS(ArrayList<ArrayList<Integer>> triangle, int row, int column, int sum, int minSum) {
		// add itself
		
		sum += triangle.get(row).get(column);
		
		if (row == triangle.size() - 1) { // last row
			if (sum < minSum) return sum;
		} else {
			minSum = DFS(triangle, row+1, column, sum, minSum);
			minSum = DFS(triangle, row+1, column+1, sum, minSum);
		}
		
		return minSum;
	}
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
		return DFS(triangle, 0, 0, 0, Integer.MAX_VALUE);
	}
}
