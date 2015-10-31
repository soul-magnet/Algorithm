package String;
/*
 * Compare two strings A and B,
 * determine whether A contains all of the characters in B
 * The characters in string A and B are all Upper Case letters
 * Example:
 * For A = "ABCD", B = "ACD", return true.
 * For A = "ABCD", B = "AABC", return false.
 * Note:
 * The characters of B in A are not necessary continuous or ordered
 * 
 * Analysis: 
 * Count the number of occurrence for StringA.
 * Count the number of occurrence for StringB.
 * Check, if all of String B's char# <= String A's char# at each index.
 * A string traversal, traverse String B, the worst time complexity of O(2n),
 * and space complexity is O(26)
 * */
public class CompareStrings {
	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
	
	public boolean compareStrings(String A, String B) {
		if (A.length() < B.length() || A == null || B == null){
			return false;
		}
		int[] store = new int[26];
		
		for (int i = 0; i < A.length(); i++) {
			store[A.charAt(i) - 'A']++;
		}
		
		for (int i = 0; i < B.length(); i++) {
			store[B.charAt(i) - 'A']--;
			if (store[B.charAt(i) - 'A'] < 0){
				return false;
			}
		}
		
		return false;
		
	}
	
}
