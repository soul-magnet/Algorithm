package main.java.ladders.BinaryTree;
/* Given n, how many structurally unique BSTs (binary search trees) 
 * that store values 1...n?
 * 
 * Example
Given n = 3, there are a total of 5 unique BST's.

1           3    3       2      1
 \         /    /       / \      \
  3      2     1       1   3      2
 /      /       \                  \
2     1          2                  3

Analysis: DP problem
The case for 3 elements example
Count[3] = Count[0]*Count[2]  (1 as root)
              + Count[1]*Count[1]  (2 as root)
              + Count[2]*Count[0]  (3 as root)

Therefore, we can get the equation:
Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1  
* 
*/
public class UniqueBinarySearchTrees {
	/**
     * @paramn n: An integer
     * @return: An integer
     */
	 public int numTrees(int n) {
		 int[] count = new int[n + 2];
		 count[0] = 1;
		 count[1] = 1;
		 
		 for (int i = 2; i<= n; i++){
			 for (int j = 0; j < i; j++){
				 count[i] += count[j] * count[i - j -1];
			 }
		 }
		 return count[n];
	 }
}
