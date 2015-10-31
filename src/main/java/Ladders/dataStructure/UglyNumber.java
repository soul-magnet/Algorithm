package DataStructure;
/*
 * Analysis:
 * Algorithm, Loop for all positive integers until ugly number count is smaller than n.
 * if an integer is ugly then increment ugly number count. 
 * 
 * To check if a number is ugly, divide the number by greatest divisible powerd of 2, 3, and 5
 * if the number becomes 1 then it is an ugly number otherwise not.
 * 
 * For example, let us see how to check for 300 is ugly or not. 
 * Greatest divisible power of 2 is 4, after dividing 300 by 4 we get 75. 
 * Greatest divisible power of 3 is 3, after dividing 75 by 3 we get 35.
 * Greatest divisible power of 5 is 25, after dividing 25 by 25 we get 1. 
 * Since we get 1 finally, 300 is ugly number. 
 * 
 * Dynamic Programming Algorithm:
 * 1. Declare the array of ugly numbers: ugly[150]
 * 2. Initialize first ugly no: ugly[0] = 1;
 * 3. Initialize three array index variables i2, i3, i5 to point to 1st
 * 	  element of the ugly array:
 * 4. Initialize 3 choices for the next ugly no:
 *  */
public class UglyNumber {

}
