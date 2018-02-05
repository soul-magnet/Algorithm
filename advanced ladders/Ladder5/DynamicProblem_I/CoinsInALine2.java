package Ladder5.DynamicProblem_I;
/**
 * 395. Coins in a Line II - Medium - Required

There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until there are no more coins left. 
The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.

Tags: Array Dynamic Programming Game Theory

Related Problems 
Hard Coins in a Line III 34 %
Medium Coins in a Line 43 %
 * */
public class CoinsInALine2 {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin1(int[] values) {
		// write your code here
		int[] dp = new int[values.length + 1];
		boolean[] flag = new boolean[values.length + 1];
		int sum = 0;
		for (int now : values) {
			sum += now;
		}

		return sum < 2 * MemorySearch(values.length, dp, flag, values);
	}

	int MemorySearch(int n, int[] dp, boolean[] flag, int[] values) {
		if (flag[n] == true) {
			return dp[n];
		}
		flag[n] = true;
		if (n == 0) {
			dp[n] = 0;
		} else if (n == 1) {
			dp[n] = values[values.length - 1];
		} else if (n == 2) {
			dp[n] = values[values.length - 1] + values[values.length - 2];
		} else if (n == 3) {
			dp[n] = values[values.length - 2] + values[values.length - 3];
		} else {
			dp[n] = Math.max(
					Math.min(MemorySearch(n - 2, dp, flag, values),
							MemorySearch(n - 3, dp, flag, values))
							+ values[values.length - n],
							Math.min(MemorySearch(n - 3, dp, flag, values),
									MemorySearch(n - 4, dp, flag, values))
									+ values[values.length - n]
											+ values[values.length - n + 1]);
		}

		return dp[n];
	}
	
		public boolean firstWillWin(int[] values) {
		if(values==null||values.length==0){return false;}
		int n = values.length;
		if(n<=2){return true;}
		int dp[] = new int [n+1];boolean []visited = new boolean[n+1];
		dp[0]=0 ; dp[1] = values[n-1];dp[2]=values[n-1]+values[n-2];dp[3]= values[n-2] + values[n-3];
		int sum =0; for(int i : values){sum +=i;}
		return sum< 2* memorySearch(values, n, dp,visited);
	}

	private int memorySearch(int[] values, int n, int[] dp, boolean[] visited) {
	    if(n<=3){
	        return dp[n];
	    }
		if(visited[n]){
			return dp[n];
		}//first needs to choose
		dp[n]= Math.max(
				Math.min(memorySearch(values,n-2, dp, visited),memorySearch(values,n-3, dp, visited))+values[values.length-n],
				Math.min(memorySearch(values,n-4, dp, visited),memorySearch(values,n-3, dp, visited))+values[values.length-n]+values[values.length-n+1]);
		visited[n]=true;
		return dp[n];
	}
}
