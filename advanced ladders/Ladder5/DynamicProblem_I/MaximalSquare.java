package Ladder5.DynamicProblem_I;
/**
 * 
 * 436. Maximal Square - Medium - Required

Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing all 1's and return its area.

Example
For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

Tags: Airbnb Dynamic Programming Facebook

Related Problems 
Easy Check Sum of Square Numbers 15 %
Medium Maximal Square II 34 %
Hard Maximal Rectangle 26 %
 * 
 * */
public class MaximalSquare {
	
	 /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare1(int[][] m) {
		if(m==null||m.length==0) return 0;
				int res =0, row= m.length, col=m[0].length, dp[][] = new int [row][col];
				for(int i =0; i<row; i++){ dp[i][0]=m[i][0];res = Math.max(res, dp[i][0]);
					for(int j=1; j<col;j++){
						if(i>0&&j>0&&m[i][j]==1){
							dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1])+1;
						
						}else{
							dp[i][j] = m[i][j];
						}
						res = Math.max(res, dp[i][j]);
					}
				}
				return res*res;
			}
			public int maxSquare(int[][] m) {
				if(m==null||m.length==0) return 0;
				int res =0, row= m.length, col=m[0].length, dp[][] = new int [2][col];
				for(int i =0; i<row; i++){ dp[i%2][0]=m[i][0];res = Math.max(res, dp[i%2][0]);
					for(int j=1; j<col;j++){
						if(i>0&&j>0&&m[i][j]==1){
							dp[i%2][j] = Math.min(Math.min(dp[(i-1)%2][j-1],dp[(i-1)%2][j]), dp[i%2][j-1])+1;
		
						}else{
							dp[i%2][j] = m[i][j];
						}
						res = Math.max(res, dp[i%2][j]);
					}
				}
				return res*res;
			}

}
