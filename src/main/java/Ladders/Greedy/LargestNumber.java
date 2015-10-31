package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a list of non negative integers, arrange them such that 
 * they form the largest number.
 * Example: Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Analysis:
 * This problem can be solve by simply sorting strings, not sorting integer.
 * Define a comparator to compare string by concat() right-to-left or left-to right.
 * 
 * 1. All the numbers are used, which means no need to choose
 * 2. Order of the numbers is important.(May use sorting algorithm)
 * 3. How to determine the order of like 30 and 3? 3>30 or 3<30 ?
 * 
 * So it is natural to think that sorting is all we need. 
 * if i can get the sorted lists of number, the last step is just concatenate
 * them and output as a string
 * 
 * Sort can be done by library functions, where we need to define 
 * the compare function. 
 * 
 * How to define compare function? 
 * 1. Consider two integer, a and b. For example 34 and 3.
 * 2. Actually what we need to compare id not 34 and 3, but 3 43 and 3 34.
 * 3. If 343 > 334, then 34 should have higher order than 3, and vice versa. 
 * 

*/
class NumbersComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}
public class LargestNumber {
	/**
     *@param num: A list of non negative integers
     *@return: A string
     */
	
	public String largestNumber(int[] num){
		String[] strs = new String[num.length];
		for (int i = 0; i < num.length; i++){
			strs[i] = Integer.toBinaryString(num[i]);
		}
		
		Arrays.sort(strs, new NumbersComparator());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++){
			sb.append(strs[i]);
		}
		String result = sb.toString();
		
		int index = 0;
		while (index < result.length() && result.charAt(index) == '0'){
			index++;
		}
		
		if(index == result.length()){
			return "0";
		}
		return result.substring(index);
	}
	
	// Another Implementation
	public String largestNumber2(int[] num){
		String[] str = new String[num.length];
        for (int i=0; i < num.length; i++){
            str[i] = String.valueOf(num[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1, String s2){
                String leftRight = s1+s2;
                String rightLeft = s2+s1;
                return -leftRight.compareTo(rightLeft);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s: str){
            sb.append(s);
        }
        
        while(sb.charAt(0)=='0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
	}
}
