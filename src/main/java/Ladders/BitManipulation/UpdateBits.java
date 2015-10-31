package BitManipulation;
/*
 * Given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * Write a method to set all bits between i and j in N equal to M 
 * (e g , M becomes a substring of N located at i and starting at j)
 * Example: Given N=(10000000000)2, M=(10101)2, i=2, j=6
 * return N=(10001010100)2
 * Note: In the function, the numbers N and M will given in decimal, 
 * you should also return a decimal number.
 * Challenge: Minimum number of operations?
 * Clarification: You can assume that the bits j through i 
 * have enough space to fit all of M. 
 * That is, if M=10011， you can assume that there are at least 5 bits 
 * between j and i. You would not, for example, have j=3 and i=2, 
 * because M could not fully fit between bit 3 and bit 2.
 * 
 * Analysis: Use bit masking. O(1)
 * x & 0 = 0
 * x & 1 = x
 * 1. Make a 7 mask to transform N[i ... j] to 0
 * 2. Add M to N[i ... j]
 * 
 * */
public class UpdateBits {
	 /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
	
	public int updateBits(int n, int m, int i, int j){
		int mask;
		if (j < 31){
			mask = ~((1 << (j + 1)) - (1 << i));
		} else {
			mask = (1 << i) - 1;
		}
		return (m << i) + (mask & n);
	}
	
	public int updateBits2(int n, int m, int i, int j){
		int ones = ~0;
        int mask = 0;
        if (j < 31){
            int left = ones << (j  + 1);
            int right = ((1 << i) - 1);
            mask = left | right;
        } else {
            mask = (1 << i) - 1;
        }
        
        
        
        return (n & mask) | (m << i);
	}
}
