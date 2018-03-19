package Google;
/**
 * Related Question: http://www.lintcode.com/en/problem/maximum-subarray/
 * 
 * Given a sequence of numbers, find three substrings of length k that are not covered by one another, 
 * making the sum of their numbers the maximum. 
 * The output value is the start subscript of the three substrings. 
 * If there is more than one solution, the output dictionary sequence is the smallest one
 * 
 * Example: Enter: [1,2,1,2,6,7,5,1], 2 Output: [0,3,5]

Analysis of problem solving ideas

First preprocessing the prefix sum so that sum [i] represents a substring sum of length k ending in the ith number, 
to facilitate the later calculation of the sum of certain intervals.
The easiest way is to traverse the beginning of the three paragraphs, summation, the time complexity is O (n ^ 3).

So how to optimize it?
We do not consider the subscript, only consider the largest answer. 
If it is known that the maximum sum of one string of the first n characters 
satisfying the meaning of "a substring of length k not covered with each other" is sum_max, 
then adding the value of the current string to form the first n + 1 Strings in line with the description of the two largest and sum, sum_max + value.

Therefore, for the summation of the ith position, we consider the state transition from [0, ik], 
add new substrings to the known substrings and find the two strings of maxima. 
By the same token, if we do the same from back to front, 
we get the maximum of two strings of i bits from back to front.

In other words, we can consider dividing it into three regions [0, ik] [i, i + k-1] [i + k, len). 
We only need to enumerate the middle sum [i] The maximum prefix to the current position and 
the maximum suffix sum from right to the current position must be the maximum sum that the current position can find, 
and the traversal can obtain the final solution.
 * */
public class MaxSumOf3NonRepeatingSubarrays {

}
