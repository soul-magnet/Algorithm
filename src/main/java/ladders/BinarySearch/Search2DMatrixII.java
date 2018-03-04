package main.java.ladders.BinarySearch;
/**
 * 38. Search a 2D Matrix II - Medium - Optional
 
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Have you met this question in a real interview? 
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

Challenge 
O(m+n) time and O(1) extra space

Tags: Matrix Google Sorted Matrix

Related Problems 
Medium Count Negative Number 23 %
Easy Search a 2D Matrix 28 %
 * 
 * */
public class Search2DMatrixII {
	/**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0||matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int ct=0; int x= matrix.length-1, y = 0;
        while(x>=0&&y<matrix[0].length){
            if(matrix[x][y]>target){
                x--;
            }else if(matrix[x][y]<target){
                y++;
            }else{
                ct++;
                x--;
                y++;
            }
        }
        return ct;
    }

}
