package Google;
/**
 * 38. Search a 2D Matrix II - Google - Onsite

Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.

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

Tags: Google Matrix Sorted Matrix

Related Problems 
Easy Search a 2D Matrix 28 %
 * 
 * http://www.jiuzhang.com/qa/7376/
 * */
public class Search2DMatrix2 {
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
    
    //Juizhang SOlution
    public int searchMatrix2(int[][] matrix, int target) {
        // check corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        // from bottom left to top right
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n - 1;
        int y = 0;
        int count = 0;
        
        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }



// version: 高频题班

    public int searchMatrix1(int[][] matrix, int target) {
        // write your code here
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                r--;
                c++;
                continue;
            }
            if (target < matrix[r][c]) {
                r--;
            } else {
                c++;
            }
        }
        return ans;
    }

}
