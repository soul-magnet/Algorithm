package Ladder5.DynamicProblem_I;
/**
 * 398. Longest Increasing Continuous subsequence II - Hard - Required

Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence 
in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or 
column and go up/down/right/left any direction).

Example
Given a matrix:

[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25

Challenge 
O(nm) time and memory.

Tags: Dynamic Programming
Related Problems 
Easy Longest Increasing Continuous Subsequence 30 %
 * */
public class LongestIncreasingContinuousSubsequence2 {
	/**
     * @param A an integer matrix
     * @return  an integer
     */
      int [][]dp;
    int [][]flag ;
    int n ,m;
    public int longestIncreasingContinuousSubsequenceII1(int[][] A) {
        // Write your code here
        if(A.length == 0)
            return 0;
        n = A.length;
         m  = A[0].length;
        int ans= 0;
        dp = new int[n][m];
        flag = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    
    int search(int x, int y, int[][] A)   {
        if(flag[x][y] != 0)    
            return dp[x][y];
        
        int ans = 1; 
        int nx , ny;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(0<= nx && nx < n && 0<= ny && ny < m ) {
                if( A[x][y] > A[nx][ny]) {
                    ans = Math.max(ans,  search( nx, ny, A) + 1);
                }
            }
        }
        flag[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }
    
    public int longestIncreasingContinuousSubsequenceII(int[][] a) {
        // Write your code here
        if(a==null||a.length == 0) return 0;
        int n = a.length,m  = a[0].length, res= 0,dp[][] = new int[n][m], visited[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                dp[i][j] = search(i, j, a, dp, visited);
                 //System.out.println(dp[i][j] +" "+ a[i][j]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    
    int search(int x, int y, int[][] a, int dp[][], int visited[][])   {
        if(visited[x][y] != 0)
            return dp[x][y];
        int res = 1;
        visited[x][y] = -1;//dfs avoid circle
        for(int crt[]: d) {
         int  nx = x + crt[0];
         int   ny = y + crt[1];
            if(0<= nx && nx < a.length && 0<= ny && ny < a[0].length&&a[x][y] > a[nx][ny]&& visited[nx][ny] != -1 )//
             {res = Math.max(res,  search( nx, ny, a, dp, visited) + 1);}
        }//memerize track
        visited[x][y] = 1;
        dp[x][y] = res;
       
        return res;
    }
}
