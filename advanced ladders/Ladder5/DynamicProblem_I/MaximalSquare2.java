package Ladder5.DynamicProblem_I;
/**
 * 631. Maximal Square II 

Given a 2D binary matrix filled with 0's and 1's, find the largest square which diagonal is all 1 and others is 0.

 Notice
Only consider the main diagonal situation.

Example
For example, given the following matrix:

1 0 1 0 0
1 0 0 1 0
1 1 0 0 1
1 0 0 1 0
Return 9

Tags 
Dynamic Programming
Related Problems 
Medium Maximal Square 30 %
 * */

//Juizhang Solution
public class MaximalSquare2 {
	/**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if (n == 0)
            return 0;

        int m = matrix[0].length;
        if (m == 0)
            return 0;

        int[][] f = new int[n][m];
        int[][] u = new int[n][m];
        int[][] l = new int[n][m];

        int length = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    f[i][j] = 0;
                    u[i][j] = l[i][j] = 1;
                    if (i > 0)
                        u[i][j] = u[i - 1][j] + 1;
                    if (j > 0)
                        l[i][j] = l[i][j - 1] + 1;
                } else {
                    u[i][j] = l[i][j] = 0;
                    if (i > 0 && j > 0)
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(u[i - 1][j], l[i][j - 1])) + 1;
                    else 
                        f[i][j] = 1;
                }
                length = Math.max(length, f[i][j]);
            }
        return length * length;
    }

}
