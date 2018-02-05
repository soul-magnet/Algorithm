package Ladder3.DataStructure_II;

import java.util.Stack;

/**
 * 510. Maximal Rectangle - Hard - Required
 * 
Given a 2D boolean matrix filled with False and True, 
find the largest rectangle containing all True and return its area.

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1, 1, 0, 0, 1],
  [0, 1, 0, 0, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1]
]
return 6.

Tags: Stack Array Dynamic Programming

Related Problems 
Medium Maximal Square 30 %
Hard Largest Rectangle in Histogram 28 %
 * */
public class MaximalRectangle {
	 /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle1(boolean[][] matrix) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;

        int M = Math.max(m, n);
        int N = Math.min(m, n);

        int ans = 0;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];//collection of the col
            for (int y = x; y < N; y++) {
                int num = 0;
                for (int z = 0; z < M; z++) {
                    if(y==x){
                        if((m > n ? matrix[z][y] : matrix[y][z])){
                            sums[z] += 1;
                        } else{
                            sums[z]=0;
                            num =0;
                            continue;
                        }
                    }else{
                        if(sums[z]==0) {
                            num =0;
                            continue;
                        }else{
                            if((m > n ? matrix[z][y] : matrix[y][z])){
                                sums[z] += 1;
                                //set.add(sums[z]);
                            }else{
                                sums[z]=0;
                                num =0;
                                continue;
                            }
                        }
                    }
                    num += sums[z];
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix.length < 1) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] height = new int[n][m];// h[i][j] means from h[0][j] to h[i][j] max height
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0)
                    height[i][j] = ((matrix[i][j]) ? 1 : 0);
                else
                    height[i][j] += ((matrix[i][j]) ? height[i-1][j] + 1 : 0);
            }
        }
        int answer = 0;// singular stack to solve largest rectangle in histogram
        for (int i = 0; i < n; ++i) {
            Stack<Integer> S = new Stack<Integer>();
            for (int j = 0; j < m; j++) {
                while (!S.empty() && height[i][j] < height[i][S.peek()]) {
                    int pos = S.peek();
                    S.pop();
                    answer = Math.max(answer, height[i][pos]*(S.empty()? j : j-S.peek()-1));
                }
                S.push(j);
            }
            while (!S.empty()) {
                int pos = S.peek();
                S.pop();
                answer = Math.max(answer, height[i][pos]*(S.empty()? m : m-S.peek()-1));
            }
        }
        return answer;
    }

}
