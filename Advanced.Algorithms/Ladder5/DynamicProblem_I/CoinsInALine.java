package Ladder5.DynamicProblem_I;
/**394. Coins in a Line - Medium - Required
 
There are n coins in a line. 
Two players take turns to take one or two coins from right side until there are no more coins left. 
The player who take the last coin wins.

Could you please decide the first play will win or lose?


Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

Challenge 
O(n) time and O(1) memory

Tags 
Array Greedy Dynamic Programming Game Theory
Related Problems 
Hard Coins in a Line III 34 %
Medium Coins in a Line II 32 %
 * 
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

//Juizhang Solution
//方法一
//public class Solution {
// /**
//  * @param n: an integer
//  * @return: a boolean which equals to true if the first player will win
//  */
// public boolean firstWillWin(int n) {
//     // write your code here
//     int []dp = new int[n+1];
//     
//     return MemorySearch(n, dp);
//     
// }
// boolean MemorySearch(int n, int []dp) { // 0 is empty, 1 is false, 2 is true
//     if(dp[n] != 0) {
//         if(dp[n] == 1)
//             return false;
//         else
//             return true;
//     }
//     if(n <= 0) {
//         dp[n] = 1;
//     } else if(n == 1) {
//         dp[n] = 2;
//     } else if(n == 2) {
//         dp[n] = 2;
//     } else if(n == 3) {
//         dp[n] = 1;
//     } else {
//         if((MemorySearch(n-2, dp) && MemorySearch(n-3, dp)) || 
//             (MemorySearch(n-3, dp) && MemorySearch(n-4, dp) )) {
//             dp[n] = 2;
//         } else {
//             dp[n] = 1;
//         }
//     }
//     if(dp[n] == 2) 
//         return true;
//     return false;
// }
//}
//
////方法二 StackOverflow
//public class Solution {
// /**
//  * @param n: an integer
//  * @return: a boolean which equals to true if the first player will win
//  */
// public boolean firstWillWin(int n) {
//     // write your code here
//     boolean []dp = new boolean[n+1];
//     boolean []flag = new boolean[n+1];
//     return MemorySearch(n, dp, flag);
// }
// boolean MemorySearch(int i, boolean []dp, boolean []flag) {
//     if(flag[i] == true) {
//         return dp[i];
//     }
//     if(i == 0) {
//         dp[i] = false;
//     } else if(i == 1) {
//         dp[i] = true;
//     } else if(i == 2) {
//         dp[i] = true;
//     } else {
//         dp[i] = !MemorySearch(i-1, dp, flag) || !MemorySearch(i-2, dp, flag);
//     }
//     flag[i] =true;
//     return dp[i];
// }
//}
//
////方法三
//public class Solution {
// /**
//  * @param n: an integer
//  * @return: a boolean which equals to true if the first player will win
//  */
// public boolean firstWillWin(int n) {
//     // write your code here
//     if (n == 0)
//         return false;
//     else if (n == 1)
//         return true;
//     else if (n == 2)
//         return true;
//         
//     boolean []dp = new boolean[n+1];
//     dp[0] = false;
//     dp[1] = true;
//     dp[2] = true;
//     for (int i = 3; i <= n; i++) 
//         dp[i] = !dp[i - 1] || !dp[i - 2];
//         
//     return dp[n];
// }
//}
