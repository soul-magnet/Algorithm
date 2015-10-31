package BitManipulation;
/*
 *Calculate the a^n % b where a, b and n are all 32bit integers.
 *Have you met this question in a real interview? Yes
 *Example: For 2^31 % 3 = 2
 *For 1001000 % 1000 = 0
 *Challenge: O(logn) 
 *
 *Analysis:  Math problem, have to know equivalance of modulo %
 *
 *(a + b)mod n = ((a mod n) + b mod n)mod n
 *a*b mod n = ((a mod n)(b mod n))mod n
 *(a mod n)mod n = a mod n
 */
public class FastPower {
	/*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
	
	public int fastPower(int a, int b, int n) {
		if (n == 1)
			return a % b;
		
		if (n == 0)
			return 1 % b;
		
		long half = fastPower(a, b, n /2);
		long result = (half * half) % b;
		if (n % 2 == 1){
			result = (result * a) % b;
		}
		
		return (int) result;
	}
}
