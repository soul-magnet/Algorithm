package IntegerArray;

import java.util.HashMap;

/*
 * Given an array of integers, find two numbers such that
 * they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are NOT zero-based.
 * 
 * Example
 * numbers=[2, 7, 11, 15], target=9
 * return [1, 2]
 * 
 * Note
 * You may assume that each input would have exactly one solution
 * Challenge
 * Either of the following solutions are acceptable:
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * 
 * 
 * Analysis: 
 * - Brute Force:
 * - If we use brute force to solve Two Sum, it will cost us O(n^2) to find the answer
 * - Similarly, the complexity of 3 Sum using brute force is O(n^3), which is not good for these problems 
 * 
 * Sorting
 * We can sort the array to make it easier. For Two sum, if the array is sorted, 
 * We can use two pointers pointing to the head and the end.
 * If the sum is larger than target, we can move the second pointer left. 
 * We will continue doing this until we find the target or the position of first
 * pointer is larger than the second pointer. 
 * We can also use this in 3 Sum. We can use each entry as a candidate. 
 * For example; we now searching 2 other elements in the array that makes their sum to target - num[i].
 * We can check the entries from i + 1 to num.length - 1, with the method mentioned above.
 * 
 * 3 Sum Closest can also be solved like this. We just check every candidate for the most closest one.
 * 
 * Complexity of this method is better than brute force method. Sorting the array costs O(nlogn). 
 * So for two sum, it costs O(nlogn).
 * For 3 Sum it costs O(nlogn) + O(n^2) = O(n^2).
 * For 4 Sum, it costs O(n^3)
 * 
 * HashMap:
 * 
 * We can use HashMap to improve this algorithm. For example, 
 * It can improve Two Sum from O(nlogn) to O(n). That is, saving every number in the HashMap as well as its position.
 * And then we can go through the array and check for the existence number target - i in O(1).
 * So we only need O(n). Similarly, with HashMap we can solve 3 sum in O(n^2) and 4 Sum in O(n^2).
 * 
 * Duplication:
 * 
 * In some problems we are required to output non-duplicate result. We can use HashSet to achieve this. 
 * 
 *Reference: http://tech-wonderland.net/blog/summary-of-ksum-problems.html
 * 
 * */
public class IISum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		
		if (numbers == null | numbers.length == 0){
			return result;
		}
		
		HashMap<Integer, Integer>map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++){
			map.put(target - numbers[i], i);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])){
				if (map.get(numbers) != i) {
					return new int[] { i + 1, map.get(numbers[i]) + 1};
				}
			}
		}
		
		return result;
	}
	

}
