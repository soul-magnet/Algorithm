package main.java.ladders.DynamicProgramming;
/**
 * 163. Unique Binary Search Trees - Medium

Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?
 
Example
Given n = 3, there are a total of 5 unique BST's.

1           3    3       2      1
 \         /    /       / \      \
  3      2     1       1   3      2
 /      /       \                  \
2     1          2                  3
Tags 
Catalan Number Dynamic Programming
Related Problems 
Medium Generate Parentheses 37 %
Easy First Position of Target 33 %
 * */
public class UniqueBinarySearchTrees {
	/**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
       if(n==0){
            return 1;
        }
       int [] ct = new int[n+1];
       ct[0]=1;
        for (int i=1; i<n+1;i++){
            for(int j =0; j<i;j++){
                ct[i]+=ct[j]*ct[i-j-1];
            }
        }
        return ct[n];
    }

}
