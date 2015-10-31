package String;
/*
 * Write a method anagram(s,t) 
 * to decide if two strings are anagrams or not.
 * Given s="abcd", t="dcab", return true.
 * Challenge:
 * O(n) time, O(1) extra space
 * 
 * Analysis: The simplest solution is comparing these two strings after sorting.
 * However, it doesn't satisfy O(n) time. 
 * Then, I thought up a solution using HashMap but it is not a O(1) extra space solution
 * The trick of this solution is using character's ASCII code as its index.
 * The value of the index is the number of occurance. 
 * */
public class TwoStringsAreAnagrams {
	/**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
	
	public boolean anagram (String s, String t) {
		if (s.length() != t.length()){
			return false;
		}
		
		if(s == null || t == null || s.length() == 0 || t.length() == 0 || 
	            s.length() != t.length()){
	            return false;   
	            
		}
		char[] array = new char[256];
		
		for (int i = 0; i < s.length(); i++){
			array[s.charAt(i)] += 1;
		}
		
		for (int j = 0; j < t.length(); j++) {
			array[t.charAt(j)] -= 1;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0){
				return false;
			}
		}
		return true;
	}
	
	/*public boolean anagram(String s,String t) {
		if (s.length() != t.length()){
			return false;
		}
		
		int [] count = new int[256];
		for (int i = 0; i < s.length(); i++) {
			count[(int)s.charAt(i)]++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			count[(int)t.charAt(i)]--;
			if (count[(int)t.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}*/
}
