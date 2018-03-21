package Microsoft_OTS2018_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Print all permutations in sorted (lexicographic) order - GeekForGeeks
 * 
 * 
 * Given a string, print all permutations of it in sorted order. For example, 
 * if the input string is “ABC”, then output should be “ABC, ACB, BAC, BCA, CAB, CBA”.	
 * We have discussed a program to print all permutations in this post, 
 * but here we must print the permutations in increasing order.
 * Following are the steps to print the permutations lexicographic-ally
 * 1. Sort the given string in non-decreasing order and print it. 
 * The first permutation is always the string sorted in non-decreasing order.
 * 2. Start generating next higher permutation. 
 * Do it until next higher permutation is not possible. 
 * If we reach a permutation where all characters are sorted in non-increasing order, 
 * then that permutation is the last permutation.
 * 
 * Steps to generate the next higher permutation:
1. Take the previously printed permutation and find the rightmost character in it, 
which is smaller than its next character. Let us call this character as ‘first character’.

2. Now find the ceiling of the ‘first character’. 
Ceiling is the smallest character on right of ‘first character’, which is greater than ‘first character’. 
Let us call the ceil character as ‘second character’.

3. Swap the two characters found in above 2 steps.

4. Sort the substring (in non-decreasing order) after the original index of ‘first character’.

Let us consider the string “ABCDEF”. Let previously printed permutation be “DCFEBA”. 
The next permutation in sorted order should be “DEABCF”. 
Let us understand above steps to find next permutation. 
The ‘first character’ will be ‘C’. The ‘second character’ will be ‘E’.
After swapping these two, we get “DEFCBA”. The final step is to sort the substring after 
the character original index of ‘first character’. Finally, we get “DEABCF”.
 * */
public class PermutationLex {
	//DFS - Recursive 	
	private void perm(char[] a, int len, List<Character> lis, int depth, Boolean[] visited) {
		if (depth > len)
			return;

		if (depth == len) {
			System.out.println(lis.subList(0, len));
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				lis.add(depth, a[i]);
				visited[i] = true;
				perm(a, len, lis, depth + 1, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		PermutationLex inst = new PermutationLex();
		char a[] = { 'A', 'B', 'C' };
		inst.perm(a, a.length, new ArrayList<Character>(), 0, new Boolean[] { false, false, false });
	}

	
	
}
