package matrix;
/*
 * You are given an n x n 2D matrix representing an image. 
 * Rotate the image by 90 degrees (clockwise).
 * Given a matrix

[
    [1,2],
    [3,4]
]
rotate it by 90 degrees (clockwise), return

[
    [3,1],
    [4,2]
]
Challenge
Do it in-place

*Analysis: Naive Solution
*A new 2D array is created to store the rotated matrix and the result 
*is assigned to the matrix at the end. This is Wrong! Why?
*
*
**/
public class RotateImage {
	 /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
        	return;
        int m = matrix.length;
        int[][] result = new int[m][m];
        for (int i = 0; i <m; i++){
        	for (int j = 0; j < m; j++){
        		result[j][m - 1 -i] = matrix[i][j];
        	}
        }
        
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < m; j++){
        		matrix[i][j] = result[i][j];
        	}
        }
    }
    // In-Place solution
    public void rotateImage(int[][] matrix){
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return;
    	int length = matrix.length;
    	for (int i = 0; i < length/ 2; i++){
    		for (int j = 0; j < (length + 1)/ 2; j++){
    			int tmp = matrix[i][j];
    			matrix[i][j] = matrix[length - j - 1][i];
    			matrix[length - j - 1][i] = matrix[length - i -1][length - j - 1];
    			matrix[length - i - 1][length - j -1] = matrix[j][length - i - 1];
    			matrix[j][length - i -1] = tmp;
    		}
    	}
    }
    
}
