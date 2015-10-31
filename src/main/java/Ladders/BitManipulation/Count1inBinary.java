package BitManipulation;
/*Count how many 1 in binary representation of a 32-bit integer.
 * Example
 * Given 32, return 1
 * Given 5, return 2
 * Given 1023, return 9
 * Challenge: If the integer is n bits with m 1 bits. Can you do it in O(m) time?
 * 
 * */
public class Count1inBinary {
	/**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
    	 int count = 0;
         while (num != 0){
             num = num & (num - 1);
             ++count;
         }
         return count;
    }
}
