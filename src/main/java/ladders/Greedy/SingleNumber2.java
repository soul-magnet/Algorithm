package main.java.ladders.Greedy;
/**
 * 83. Single Number II - Medium

Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge 
One-pass, constant extra space.

Tags: Greedy
Related Problems 
Medium Single Number IV 35 %
Medium Single Number III 36 %
Easy Single Number 46 %
Medium Majority Number III 30 %
Medium Majority Number II 31 %
Easy Majority Number 43 %
 * */
/* Analysis: 
 * The general idea of this problem is to consider all the number bit by bit, 
 * count the occurrence of '1'in each bit. To get the result, check if the number
 * can be divided by 3(mod3 = 0), put '0' if true and '1' otherwise.
 * 
 * Since we know that XOR operation can be used for testing if 1 bit occurs twice,
 * in other words, for a single bit, if 1 occurs twice, it turns to 0.
 * Now we need a 3-time criteria for each bit, by utilizing the bit operations.
 * This 3-times criteria needs every bit turns to 0 if 1 occurs 3 times.
 * 
 * If we know on which bits '1' occurs twice, and also know on which bots 
 * '1' occurs 1-time, a simple '&' operation would result in the bit 
 * where '1' occurs 3 times. Then we turn these bit to zero.
 * 
(1). Check bits which have 1-time '1', use the XOR operation.
(2). Check bits which have 2-times '1's, use current 1-time result & current number.
(3). Check bits which have 3-times '1's, use '1-time' result & '2-times' result
(4). To turn 3-times bits into 0:   ~(3-times result) & 1-time result
                                                     ~(3-times result) & 2-times result
    
E.g.,We have numbers:  101101,   001100, 101010
To count the occurrence of 1's:
101101
001100
101010
count:  {2,0,3,2,1,1}

Denote:
t1: bit=1 if current bit has 1-time '1'
t2: bit=1 if current bit  has 2-times '1'
t3: bit=1 if current bit  has 3-times '1'

Result:
t1 = 000011, t2 = 100100, t3 = 001000

Reference: http://yucoding.blogspot.com/2014/10/single-number-ii.html
 * */

/*         1110
*         1110
*         1110
*         1001
*         _____
*         4331 对每一位进行求和
*         1001 对每一位的和做%3运算，来消去所有重复3次的数
*/

// bit manipulation
public class SingleNumber2 {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
	public int singleNumberII(int[] A){
		if (A == null || A.length == 0){
			return -1;
		}
		
		// get the power of 3
		int[] pow3 = new int[20];
		pow3[0] = 1;
		for (int i = 1; i < 20; i++){
			pow3[i] = pow3[i-1] * 3;
		}
		// At most 20 bits for base 3 in maxint
		int[] bits = new int[20];
		
		for (int i = 0; i < 20; i++){
			for (int j = 0; j < A.length; j++){
				bits[i] += A[j] / pow3[i] % 3;
			}
		}
		// convert to decimal
		int result = 0;
		for (int i = 0; i < 20; i++){
			result += pow3[i] * (bits[i] % 3);
		}
		return result;
	}
	// Another Solution
	public int singleNumberII2(int[] A){
		if (A == null || A.length == 0){
			return -1;
		}
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++){
			for (int j = 0; j < A.length; j++){
				bits[i] += A[j] >> i & 1;
				bits[i] %= 3;
			}
			result |= (bits[i] << i);
		}
		return result;
	}
}

