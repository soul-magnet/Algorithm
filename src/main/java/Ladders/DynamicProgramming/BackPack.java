package DynamicProgramming;
/*
 * Given n items with size Ai, an integer m denotes the size of a backpack. 
 * How full you can fill this backpack?
 * Example : If we have 4 items with size [2, 3, 5, 7], 
 * the backpack size is 11, we can select [2, 3, 5], 
 * so that the max size we can fill this backpack is 10. 
 * If the backpack size is 12. we can select [2, 3, 7] so that 
 * we can fulfill the backpack.
 * You function should return the max size we can fill 
 * in the given backpack.
 * Note: You can not divide any item into small pieces.
 * Challenge: O(n x m) time and O(m) memory.
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * 
 * Analysis: The problem does not care how many items you can put in the 
 * backpack, it cares how you can choose the proper combination of items
 * to fully fill the backpack.
 * We create a boolean array full[n+1][m+1], with full[i][j] indicating
 * whether items in A[0] ... A[i] could fulfill the backpack with size j.
 * */
public class BackPack {
	
	public int backPack(int m, int[] A) {
        int[] store = new int[m + 1];
        store[0] = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = m; j >= 0; j--){
                if (j >= A[i]){
                    store[j] = Math.max(store[j], A[i] + store[j - A[i]]);
                }
            }
        }
        return store[m];
    }
	
	// Another implementation
	public int backPack1(int m, int[] A) {
		if (A == null || A.length == 0)
			return 0;
		
		boolean dp[][] = new boolean[A.length + 1][m + 1];
		for (int i = 0; i <= A.length; i++){
			for (int j = 0; j <= m; j++){
				dp[i][j] = false;
			}
		}
		
		dp[0][0] = true;
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j <= m; j++){
				dp[i + 1][j] = dp[i][j];
				if (j >= A[i] && dp[i][j - A[i]]){
					dp[i+1][j] = true;
				}
			} // for j
		}// for i
		
		for (int i = m; i >= 0; i--){
			if (dp[A.length][i]){
				return i;
			}
		}
		return 0;
	}

}
