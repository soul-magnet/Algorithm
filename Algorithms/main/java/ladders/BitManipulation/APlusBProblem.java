package BitManipulation;
/*
 * Write a function that add two numbers A and B. 
 * You should not use + or any arithmetic operators.
 * Example: Given a=1 and b=2 return 3
 * Note: There is no need to read data from standard input stream. 
 * Both parameters are given in function aplusb, 
 * your job is to calculate the sum and return it.
 * Challenge: Of course you can just return a + b to get accepted. 
 * But Can you challenge not do it like that?
 * Clarification: Are a and b both 32-bit integers? - Yes.
 * 				  Can I use bit operation? -Sure you can.
 * 
 * */
public class APlusBProblem {
	/*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
	public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
		/*while (b != 0){
        int carry = a & b;
        a ^= b;
        b = carry << 1;
    }
    return a;*/
    
    if (b == 0){
        return a;
    }
    return aplusb(a ^ b, (a & b) << 1);
}
}
