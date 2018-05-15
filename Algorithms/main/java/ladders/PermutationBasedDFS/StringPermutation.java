package main.java.ladders.PermutationBasedDFS;
/**
 * 211. String Permutation - Easy - Related

Given two strings, write a method to decide if one is a permutation of the other.

Example
abcd is a permutation of bcad, but abbe is not a permutation of abe

Tags 
Permutation String
Related Problems 
Medium String Permutation II 21 %
Easy Two Strings Are Anagrams 31 %
 * 
 * */
public class StringPermutation {
	 /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
	//Juizhang Solution
    public boolean Permutation(String A, String B) {
        // write your code here
    	int[] cnt = new int[1000];
    	for(int i = 0; i < A.length(); i++) {
    		cnt[(int)A.charAt(i)] += 1;
    	}
    	for(int i = 0; i < B.length(); i++) {
    		cnt[(int)B.charAt(i)] -= 1;
    	}
    	
    	for(int i = 0; i < 1000; ++i)
    		if (cnt[i] != 0)
    			return false;
    	return true;
    }
    
    //My Thinking Approach: Brute force
    //Based on the given String A, find the permutaions of A and check if
    //String B is contained in that permutations

}
