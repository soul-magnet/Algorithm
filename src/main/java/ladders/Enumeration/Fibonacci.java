package main.java.ladders.Enumeration;
/**
 * 366. Fibonacci - Easy

Find the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

 Notice
The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.

Example
Given 1, return 0

Given 2, return 1

Given 10, return 34

Tags 
Enumeration Mathematics Non Recursion
Related Problems 
Medium Replace With Greatest From Right 17 %
Medium Number of Subsequences of Form a^i b^j c^k 27 %
Medium House Robber 34 %
Easy Climbing Stairs 31 %
 * */
public class Fibonacci {
	/**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 0 || n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		}
		int[] res = new int[n];
		res[0] = 0;
		res[1] = 1;

		for (int i = 2; i < n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n - 1];
    }

}
