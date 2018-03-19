package Ladder3.DataStructure_II;

import java.util.Stack;

/**
 * 510. Maximal Rectangle 
 
Given a 2D boolean matrix filled with False and True, 
find the largest rectangle containing all True and return its area.

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

Tags:Stack Array Dynamic Programming

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

//Juizhang Solution
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];
 
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (! matrix[i][j]) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
 
        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }
 
        return maxArea;
    }
 
    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
    
        int i = 0;
        int max = 0;
     
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}

// 动态规划专题班版本
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] A) {
        // A is boolean
        // when calculating left and right, check A[i-1][j] is true
        if (A==null||A.length==0||A[0].length==0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int i, j, k, l, r, res = 0;
        
        for (i=0; i<m; ++i) {
            // calc up
            for (j=0; j<n; ++j) {
                if (!A[i][j]) {
                    up[i][j] = 0;
                }
                else {
                    up[i][j] = 1;
                    if (i>0) {
                        up[i][j] += up[i-1][j];
                    }
                }
            }
            
            // calc left
            l = 0;
            for (j=0; j<n; ++j) {
                if (!A[i][j]) {
                    l = left[i][j] = 0;
                }
                else {
                    ++l;
                    left[i][j] = l;
                    if (i>0&&A[i-1][j]&&left[i-1][j] < left[i][j]) {
                        left[i][j] = left[i-1][j];
                    }
                }
            }
            
            // calc right
            r=0;
            for (j=n-1; j>=0; --j) {
                if (!A[i][j]) {
                    r = right[i][j] = 0;
                }
                else {
                    ++r;
                    right[i][j] = r;
                    if (i>0&&A[i-1][j]&&right[i-1][j] < right[i][j]) {
                        right[i][j] = right[i-1][j];
                    }
                }
            }
        }
        
        for (i=0; i<m; ++i) {
            for (j=0; j<n; ++j) {
                res = Math.max(res, up[i][j] * (left[i][j] + right[i][j] - 1));
            }
        }
        
        return res;
    }
}
