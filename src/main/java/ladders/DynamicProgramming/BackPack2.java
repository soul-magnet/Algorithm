package main.java.ladders.DynamicProgramming;
/**
 * 125. Backpack II - Medium

Given n items with size Ai and value Vi, and a backpack with size m. 
What's the maximum value can you put into the backpack?

 Notice
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

Challenge 
O(n x m) memory is acceptable, can you do it in O(m) memory?

Tags 
LintCode Copyright Backpack Dynamic Programming
Related Problems 
Medium Minimum Partition 12 %
Medium Cutting a Rod 33 %
Medium Partition Equal Subset Sum 30 %
Medium Backpack VI 32 %
Medium Backpack 25 %
 * */
public class BackPack2 {
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
	public int backPackII(int m, int[] A, int V[]){
		int[]store = new int[m+1];
		for (int i = 0; i < A.length; i++){
			for (int j = m; j > 0; j--){
				if (A[i] <= j){
					store[j] = Math.max(store[j],V[i]+ store[j - A[i]]);
				}
			}
		}
		return store[m];
	}
	
	public int backPackII1(int m, int[] A, int V[]) {
        int[][] res = new int[A.length+1][m+1];
        res[0][0] = 0;
        for (int i=1; i<=A.length; i++) {
            for (int j=0; j<=m; j++) {
                if (j - A[i-1] < 0)
                    res[i][j] = res[i-1][j];
                if (j - A[i-1] >= 0) {
                    res[i][j] = Math.max(res[i-1][j], res[i-1][j-A[i-1]]+V[i-1]);
                }
            }
        }

        return res[A.length][m];
    }
}
