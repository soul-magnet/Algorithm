package Ladder6.DynamicProgramming_II;
/**
 * 440. Backpack III - Hard -Optional

Given n kind of items with size Ai and value Vi( each item has an infinite number available) 
and a backpack with size m. What's the maximum value can you put into the backpack?

 Notice
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.


Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10.
 The maximum value is 15.

Tags: Dynamic Programming

Related Problems 
Medium Coin Change II 30 %
Medium Minimum Partition 11 %
Medium Cutting a Rod 33 %
Medium Partition Equal Subset Sum 31 %
Medium Backpack VI 32 %
Medium Backpack V 45 %
Medium Backpack IV 42 %
Medium Backpack II 40 %
Medium Backpack 25 %
 * 
 * */
public class BackPack3 {
	
	/**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] a, int[]v, int m) {
          int dp[] = new int[m+1];

        for (int i = 0; i < a.length; i++) {
            for (int j =a[i]; j < m+1; j++) {
                dp[j] = Math.max(dp[j], dp[j - a[i]] + v[i]);
            }
        }
        return dp[m];
    }

}
