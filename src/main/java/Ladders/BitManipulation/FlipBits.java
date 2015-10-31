package BitManipulation;
/* Determine the number of bits required to flip if you want to convert 
 * integer n to integer m. 
 * Example: Given n = 31 (11111), m = 14 (01110), return 2.
 * Note: Both n and m are 32-bit integers.
*/
public class FlipBits {
	/**
     *@param a, b: Two integer
     *return: An integer
     */
	
	public static int bitSwapRequired(int a, int b){
		if (a == b)
			return 0;
		int bit = a ^ b;
		int count = 0;
		
		// integer has 32 bits
		int number = 32;
		// you cannot just check bit > 0 in the while statement
		// becasue a or be maybe negative number
		while (number > 0 ){
			count += bit & 1;
			bit = bit >> 1; // unsigned right shift for comparing each bit with previous
			                // & operation
			number--;
		}
		return count;
	}
}
