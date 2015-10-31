package String;

/*
 * strstr (a.k.a find sub string), is a useful function in string operation.
 * Your task is to implement this function.
 * For a given source string and a target string,
 * you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 * Example:
 * If source = "source" and target = "target", return -1.
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 * Challenge:
 * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 * Clarification:
 * Do I need to implement KMP Algorithm in a real interview?
 * Not necessary. When you meet this problem in a real interview,
 * the interviewer may just want to test your basic implementation ability.
 * But make sure your confirm with the interviewer first.*/

public class StrStr {
	/**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
	
	/*
	 * Take care of some corner cases
	 * Go through each position in the source as a potential starting point
	 * 
	 */
	public int strStr (String source, String target) {
		if (target == null || source == null) return -1;
		if (target.length() == 0 && source.length() == 0) return 0;
		if (target.length() == 0 && source.length() != 0) return 0;
		if (target.length() != 0 && source.length() == 0) return -1;
		
		char[] trgt = target.toCharArray();
		char[] src = source.toCharArray();
		
		int s = 0; // current source position
		int t = 0; // position in source where the correct match starts
		
		while (s < src.length) {
			if (trgt[s - t] == src[s]) { // a match
				if ((s - t) == trgt.length - 1){ //if full match
					return s;
				}
				s++;
				return t;
			} else { // not match, reset the potential start position & 
				//current source position to the next one
				t++;
				s = t;
				
			}
		}
		
		return -1;
	}
	
	
	
}
