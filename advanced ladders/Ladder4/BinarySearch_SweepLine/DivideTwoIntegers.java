package Ladder4.BinarySearch_SweepLine;
/**
 * 414. Divide Two Integers 

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return 2147483647

Example
Given dividend = 100 and divisor = 9, return 11.

Tags 
Binary Search
Related Problems 
Easy Plus One 31 %
Easy Add Binary 25 %
 * */
public class DivideTwoIntegers {
	/**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
               if(dividend==0){
            return 0;
        }
        if(divisor==0){
            return dividend>0? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        //imp:min-2147483648 max2147483647
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;// -2147483648 2147483647
        }

        boolean negative = (dividend>0&&divisor<0)||(dividend<0&&divisor>0);
        long  a = Math.abs((long)dividend);
        long b =Math.abs((long)divisor);
        int res =0;
        while(a>=b){
            int shift =0;
            while(a>=b&&a>=(b<<shift)){
                shift++;
            }
            a -= b<<(shift-1);//remainer
            res += 1<<(shift-1);//add 2^shift-1 division res to res
        }
        
        return negative? -res:res;
    }

}

//Juizhang Solution
public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result: result;
    }
}
