package HighFrequency;
// Bit Manipulation 
/*
 * Using O(1) time to check whether an integer n is a power of 2
 * Example
 * For n=4, return true;
 * For n=5, return false;
 * 
 * Challenge
 * O(1) time
 * Tricky Solution
 * */
public class CheckPowerOf2 {
	/*
     * @param n: An integer
     * @return: True or false
     */
	public boolean checkPowerOf2(int n) {
		if (n <= 0) return false; 
		boolean res = ((n & (n - 1)) == 0) ? true : false;
		return res;
	}
}
