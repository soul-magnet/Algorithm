package Ladder6.DynamicProgramming_II;
/**
 * 476. Stone Game - Medium - Required
 
There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Example
For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43

Tags: Dynamic Programming

Related Problems 
Medium Calculate Maximum Value II 30 %
Medium Stone Game II 41 %
Hard Burst Balloons 32 %
 * */
public class StoneGame {
	
	/**
     * @param A an integer array
     * @return an integer
     */
     
     public static int stoneGame(int[] a) {
		if(a==null||a.length==0){
			return 0;
		}int n= a.length;
		int dp[][] = new int [n][n];
		boolean visited[][] = new boolean [n][n];
		int sum [][] = new int [n][n];
		for(int i =0; i<n;i++){
			dp[i][i]= 0;visited[i][i]=true;sum[i][i]=a[i];
			for (int j=i+1;j<n;j++){
				
				sum[i][j]=sum[i][j-1]+a[j];
				if(j==i+1){
					visited[i][j]=true;
					dp[i][j]=sum[i][j];
				}
			}
		}
		return momorySearch(0,n-1,sum, visited, dp);
	}

	private static int momorySearch(int l, int r, int[][] sum, boolean[][] visited, int[][] dp) {
		if(l==r||visited[l][r]||l+1==r){
			return dp[l][r];
		}
		dp[l][r] = Integer.MAX_VALUE;
		for(int k=l; k<r;k++){
		    
			dp[l][r] = Math.min(dp[l][r],momorySearch(l,k,sum, visited, dp)+momorySearch(k+1,r,sum, visited, dp)+sum[l][r]);
		}
		visited[l][r] =true;
		return dp[l][r];
	}
   	public static int stoneGame1(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int len = a.length;
		int[][] f = new int[len][len];
		int[][] sum = new int[len][len];
		boolean[][] visited = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			f[i][i] = 0;
			sum[i][i] = a[i];
			visited[i][i] = true;

			for (int j = i + 1; j < len; j++) {
				sum[i][j] = sum[i][j - 1] + a[j];
			}

		}

		return msearch(0, len - 1, a, f, visited, sum);
	}

	private static int msearch(int l, int r, int[] a, int[][] f,
			boolean[][] visited, int[][] sum) {
		if (visited[l][r] == true) // including l=r and l=r-1

		{
			return f[l][r];
		}

		// if (l>r){
		// f[l][r]= Integer.MAX_VALUE;
		// }
		f[l][r] = Integer.MAX_VALUE;
		for (int i = l; i < r; i++) {
			f[l][r] = Math.min(f[l][r], msearch(l, i, a, f, visited, sum)
					+ msearch(i + 1, r, a, f, visited, sum) + sum[l][r]);
		}
		visited[l][r] = true;
		return f[l][r];
	}

}
