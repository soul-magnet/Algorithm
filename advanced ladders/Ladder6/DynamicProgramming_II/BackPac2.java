package Ladder6.DynamicProgramming_II;
/**
 * 125. Backpack II - Medium - Optional

Given n items with size Ai and value Vi, and a backpack with size m. 
What's the maximum value can you put into the backpack?

 Notice
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], 
and a backpack with size 10. The maximum value is 9.

Challenge 
O(n x m) memory is acceptable, can you do it in O(m) memory?

Tags: LintCode Copyright Backpack Dynamic Programming

Related Problems 
Medium Minimum Partition 11 %
Medium Cutting a Rod 33 %
Medium Partition Equal Subset Sum 31 %
Medium Backpack VI 32 %
Medium Backpack V 45 %
Medium Backpack IV 42 %
Hard Backpack III 54 %
Medium Backpack 25 %
 * */
public class BackPac2 {
	
	 /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
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
    public int backPackII(int m, int[] a, int v[]) {
		int f[] = new int[m + 1];
		for (int i = 0; i < m + 1; i++) {
			f[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = m; j >= a[i]; j--) {
				f[j] = Math.max(f[j], f[j - a[i]] + v[i]);
			}
		}
		return f[m];
	}

}
