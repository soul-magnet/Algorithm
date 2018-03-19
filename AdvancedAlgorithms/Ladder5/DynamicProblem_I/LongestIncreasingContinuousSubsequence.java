package Ladder5.DynamicProblem_I;
/**
 * 
 * 397. Longest Increasing Continuous Subsequence - Easy - Required

Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
 Notice
O(n) time and O(1) extra space.


Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

Tags 
Enumeration Array Dynamic Programming
Related Problems 
Hard Longest Increasing Continuous subsequence II 29 %
 */
public class LongestIncreasingContinuousSubsequence {
	
	/**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence1(int[] a) {
		if (a.length < 2) {
			return a.length;
		}
		int ct = 1, min = -1;
		boolean mod = true;

		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1] && mod != true) {
				min = Math.max(ct, min);
				ct = 2;
				mod = true;

			} else if (a[i] > a[i - 1] && mod == true) {
				ct++;
				
			} else if (a[i] < a[i - 1] && mod != false) {
				min = Math.max(ct, min);
				ct = 2;
				mod = false;
			} else if (a[i] < a[i - 1] && mod == false) {

				ct++;
				
			} else {
				min = Math.max(ct, min);
				ct = 1;
				mod = !mod;
			}

		}
		min = Math.max(ct, min);
		return min;
	}
	public static int longestIncreasingContinuousSubsequence(int[] a) {
		if (a.length < 2) return a.length;
		 int ct1=1, ct2=1, res=1;//self
		for(int i=1; i<a.length;i++){
			if(a[i]>=a[i-1]){
				ct1++;ct2=1;
			}else {
				ct1=1;
				ct2++;
			}
			res = Math.max(res,Math.max(ct1, ct2));
		}
		return res;
	}

}
