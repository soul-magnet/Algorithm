package Ladder6.DynamicProgramming_II;
/**
 * 94. Coins in a Line - Medium - Required
 
There are n coins in a line. Two players take turns to take one or two coins from right side 
until there are no more coins left. The player who take the last coin wins.

Could you please decide the first play will win or lose?

Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

Challenge 
O(n) time and O(1) memory

Tags: Array Greedy Dynamic Programming Game Theory

Related Problems 
Hard Coins in a Line III 34 %
Medium Coins in a Line II
 * */
public class CoinsInALine {
	/**
	 * @param n
	 *            : an integer
	 * @return: a boolean which equals to true if the first player will win
	 */
	public static boolean firstWillWin(int n) {
		boolean dp[] = new boolean [4];
		dp[0]=false;dp[1]=true;dp[2]=true;dp[3]=false;
		for(int i=4;i<=n;i++){
		dp[i%4]=(dp[(i-2)%4]&& dp[(i-3)%4]) || (dp[(i-3)%4]&& dp[(i-4)%4]) ;
		}
		return dp[n%4];
	}
	public static boolean firstWillWin1(int n) {
	//1 ture  2 false 0 not visited
		if(n==0) return false;
		if(n<=2) return true;
		 int []  dp = new int[n+1];dp[0] = 2; dp[1]=1; dp[2]=1; dp[3]= 2;
		return memerizedSeach(dp,n);
	}

	private static boolean memerizedSeach(int[] dp, int n) {
		if(dp[n]!=0){
			if(dp[n]==1){return true;}else{return false;}
		}//visited
		 if(memerizedSeach(dp, n-2)&&memerizedSeach(dp, n-3)||memerizedSeach(dp, n-3)&&memerizedSeach(dp, n-4)){
		 	dp[n] = 1;return true;}else{dp[n] = 2;return false;}
	}

}
