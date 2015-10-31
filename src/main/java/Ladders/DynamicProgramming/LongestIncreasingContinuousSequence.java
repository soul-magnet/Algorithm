package DynamicProgramming;
/*
 * Give you an integer array (index from 0 to n-1, 
 * where n is the size of this array)，find the longest increasing 
 * continuous subsequence in this array. (The definition of the longest 
 * increasing continuous subsequence here can be 
 * from right to left or from left to right)
 * Example: For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * 			For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 * Note: O(n) time and O(1) extra space.
 * 
 * */
public class LongestIncreasingContinuousSequence {
	 /**
     * @param A an array of Integer
     * @return  an integer
     */
	public int longestIncreasingContinuousSubsequence(int[] A) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        boolean fromLeft = true;
        int start = 0;
        res = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (fromLeft == true) {
                    res = Math.max(res, i - start + 1);
                } else {
                    start = i - 1;
                    fromLeft = true;
                }
            } else if (A[i] < A[i - 1]) {
                if (fromLeft == false) {
                    res = Math.max(res, i - start + 1);
                } else {
                    start = i - 1;
                    fromLeft = false;
                }
            }
        }
        return res;
    }
	
	// DFS solution
	/*
	 public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int n = A.length;
        int ans= 0;
        int []flag = new int[n];
        int []dp = new int[n];
        
        for(int i = 0; i < n; i++) {
            dp[i] = dfs(flag, dp, i, n, A);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    
    int dfs(int []flag, int []dp, int x, int n, int[] A)   {
        if(flag[x] == 1)    
            return dp[x];
        flag[x] = 1;
        int ans = 1; 
        flag [x]  =-1;
        if(x-1>=0 && A[x] < A[x-1] && flag[x-1] !=-1) {
            ans = dfs(flag, dp, x-1, n, A) + 1;
        } 
        if(x+1 < n && A[x] < A[x+1] && flag[x+1] !=-1) {
            ans = Math.max(ans,  dfs(flag, dp, x+1, n, A) + 1);
        }
        flag [x] = 1;
        dp[x] = ans;
        return ans;
    }
    */
}
