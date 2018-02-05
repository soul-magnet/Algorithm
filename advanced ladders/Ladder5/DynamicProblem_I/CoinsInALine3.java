package Ladder5.DynamicProblem_I;
/**
 * 396. Coins in a Line III - Hard -Optional

There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until 
there are no more coins left. The player with the larger amount of money wins.

Could you please decide the first player will win or lose?


Example
Given array A = [3,2,2], return true.

Given array A = [1,2,4], return true.

Given array A = [1,20,4], return false.

Challenge 
Follow Up Question:

If n is even. Is there any hacky algorithm that can decide whether first player will win or 
lose in O(1) memory and O(n) time?

Tags 
Array Dynamic Programming Game Theory
Related Problems 
Medium Coins in a Line II 32 %
Medium Coins in a Line 43 %
 * */
public class CoinsInALine3 {
	
	boolean firstWillWin(int[] v) {
		if(v==null||v.length==0)return false;
		int n= v.length, dp[][]= new int [n][n], sum=0;boolean visited[][] = new boolean[n][n];
		for(int i=0; i<n;i++){
			dp[i][i]= v[i];
			visited[i][i]=true;
			sum+=v[i];
		}

		return sum< 2*memorySearch(v, dp,visited,0, n-1);
	}

	private int memorySearch(int[] v, int[][] dp, boolean[][] visited, int l, int r) {
		if(l==r||visited[l][r]){
			return dp[l][r];
		}
		visited[l][r]=true;
		if(l>r){
			dp[l][r]=0;
		}else if(l+1==r){
			dp[l][r]=Math.max(v[l],v[r]);
		}else {//l<r
			dp[l][r] = Math.max(
					Math.min(memorySearch(v, dp,visited,l+2,r),memorySearch(v, dp,visited,l+1, r-1) )+ v[l],
					Math.min(memorySearch(v, dp,visited,l+1,r-1),memorySearch(v, dp,visited,l, r-2))+v[r]);		
		}
		return dp[l][r];
	}
    public boolean firstWillWin1(int[] values) {
		// write your code here
		int n = values.length;
		int[][] dp = new int[n + 1][n + 1];
		boolean[][] flag = new boolean[n + 1][n + 1];

		int sum = 0;
		for (int now : values) {
			sum += now;
		}

		return sum < 2 * MemorySearch1(0, values.length - 1, dp, flag, values);
	}


		private int MemorySearch1(int l, int r, int[][] dp, boolean[][] flag,
			int[] v) {
		if (flag[l][r]) {
			return dp[l][r];
		}
		flag[l][r] = true;
	   	if (l > r) {
			// error: return 0; not register the data to dp[][];
			dp[l][r] = 0;
		}
	    else	if (l == r) {
			// error: return v[l];
			dp[l][r] = v[l];
		}
	    else	if (l + 1 == r) {
			// error:return Math.max(v[l], v[r]);
			dp[l][r] = Math.max(v[l], v[r]);
		}
        else{
		int l_pick = Math.min(MemorySearch1(l + 1, r - 1, dp, flag, v),
				MemorySearch1(l + 2, r, dp, flag, v)) + v[l];
		int r_pick = Math.min(MemorySearch1(l + 1, r - 1, dp, flag, v),
				MemorySearch1(l, r - 2, dp, flag, v)) + v[r];
		dp[l][r] = Math.max(l_pick, r_pick);}
		return dp[l][r];
	}

}
