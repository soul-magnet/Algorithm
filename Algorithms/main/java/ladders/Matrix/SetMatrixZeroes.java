package main.java.ladders.Matrix;
/* Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place
 * Given a matrix
[
  [1,2],
  [0,3]
],
return [ [0,2], [0,0] ]

Challenge: Did you use extra space? A straight forward solution 
using O(mn) space is probably a bad idea. 
A simple improvement uses O(m + n) space, but still not the best solution. 
Could you devise a constant space solution?
 * Analysis: Using O(m+n) is easy, to enable O(1), we have to use
 * the space within the matrix
 * To reduce the space required, we can use the matrix itself to store the flags for each row
 * and column if they need to set to 0. So we need 1 row and 1 column, the first row and 1st column then can be chosen to store the flag.
 * But we need first check the two if they need to be 0. Then go the other rows and columns.
 * e.g.

1 0 2 3 4 5
2 0 2 3 4 5
3 1 2 3 4 5

First check 102345 and
1
2
3
use two flags storing the status.  fr0 = true, fc0=false;
then check the rest of matrix, use the 1st col and 1st row store the status.
1 0 2 3 4 5
0 0 2 3 4 5

1 1 2 3 4 5
Then set 0s to sub-matrix(excludes 1st row and 1st column), according to the values in 1st row and 1st column, and finally set 1st row and 1st column according to flags.

The new space used is O(1+1) = O(1).
*/
public class SetMatrixZeroes {
	 /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
	public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean empty_row0 = false;
        boolean empty_col0 = false;
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }
        
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j =1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i<rows; i++) {
            for (int j=1; j< cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
      
        if(empty_row0){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }           
        }
        
        if(empty_col0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }           
        }

    }
}
