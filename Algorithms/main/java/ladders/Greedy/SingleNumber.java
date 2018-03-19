package main.java.ladders.Greedy;

import java.util.HashSet;
import java.util.Iterator;
/**
 * 82. Single Number - Easy

Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
Given [1,2,2,1,3,4,3], return 4

Challenge 
One-pass, constant extra space.

Tags: Greedy

Related Problems 
Medium Single Number IV 35 %
Medium Find the Duplicate Number 33 %
Medium Single Number III 36 %
Medium Single Number II 40 %
Medium Majority Number III 30 %
Medium Majority Number II 31 %
Easy Majority Number 43 %
 * */
/* Analysis: 
 - The requirement is O(n) time and O(1) space.
 - Thus, the "first sort and then find" way is not working
 
 - the key to solve this problem is bit manipulation.
 - XOR will return 1 only on two different bits. 
 - So if two numbers are the same, XOR will return 0.
 - Finally only one number left.
 */
public class SingleNumber {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	// Version 1:Bit Manipulation
	public int singleNumber(int[] A) {
		if (A.length == 0){
			return 0;
		}
		int n = A[0];
		for (int i = 1; i < A.length; i++){
			n = n ^ A[i];
		}
		return n;
	}
	
	// Version 2: Use HashSet; only 1/8 test cases passed.
	public int singleNumber2(int[] A){
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : A){
			if (!set.add(n))
				set.remove(n);
		}
		Iterator<Integer> iter = set.iterator();
		return iter.next();
	}
}
