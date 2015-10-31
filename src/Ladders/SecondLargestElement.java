/*
 * @autor Emily Topkaya
 * 
 * Description: Write a Java method that takes a Collection of Integers as a parameter 
 * and returns the second largest value in the list. 
 * 
 * */
package Ladders;

import java.util.Collection;

public class SecondLargestElement {
	/**
	 * @param list	Take a collection of Integer as input.
	 * @return		null if the list is null, empty or contains only null elements.
	 * 
	 * Take a special approach to find a second largest integer within a collection.
	 * Time complexity is O(N) in one pass.
	 * For general approach, implement different sorting algorithms.
	 */
	
	public Integer findSecondLargest(Collection<Integer> list) {
		
		if (list == null || list.size() == 0) {
			return null;
		}
		
        int max= Integer.MIN_VALUE, maxSecond = Integer.MIN_VALUE;
		
        for (Integer num : list) {
        	if (num > max) {
				maxSecond = max;
				max = num;
				
			} else if (num > maxSecond ){
				maxSecond = num;
			}
		}
		
		return maxSecond;
		
	}
}
