package matrix;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than 
 * the last integer of the previous row.
 * Example: Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge: O(log(n) + log(m)) time
 * 
 * Analysis: Typical problem of binary search
 * you may try to solve this problem by finding the row first and then the column
 * But there is no need to do that. Becasue of the matrix's special features,
 * the matrix can be considered as a sorted array. Your goal is to find in this
 * sorted array by using binary search
 * */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start = 0;
		int end = m*n - 1;
		
		while (start <= end){
			int mid = (start + end)/2;
			int midX = mid/n;
			int midY = mid%n;
			
			if (matrix[midX][midY] == target){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}
