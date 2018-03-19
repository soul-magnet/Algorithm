package BitManipulation;
/* Write an algorithm which computes the number of trailing zeros in factorial
 * Example: 11! = 2^8 * 3^4 * 5^2 * 7 , so count of trailing zeroes is 2. 
 * we can easily observe that the number of 2s in prime factors 
 * is always more than or equal to the number of 5s.
 * So if we count 5s in prime factors we are done. 
 * - How to count total number of 5s in prime factors of n!?
 * A simple way ro calculate floor (n/5)
 * 
 * Trailing Zeroes in n! = Count of 5s in prime factors of n!
 * 						 = floor(n/5) + floor(n/25) + floor(n/125) + ...
 * 
 * Analysis: trailing zeros always produced by prime factors 2 and 5,
 * So if we can count the number of 2s and 5s, our task is done. */
public class TrailingZeros {
	public long trailingZeroes(long n){
		long sum = 0;
		while (n != 0){
			sum += n /5;
			n /= 5;
		}
		
		return sum;
	}
}
