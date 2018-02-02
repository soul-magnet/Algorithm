package String;

import java.util.ArrayList;
import java.util.List;

/* Knuth-Morris-Pratt algorithm: http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * Ran into leetcode “word ladder” and did not how to solve the problem with O(n) time..
 * And KMP came to help…
 * The tricky part is how to build the table…
 * Though the code is a bit hard to understand..
 * but as long as you figure out
 * whether the variable represents a 1-based count or a 0-based index..:->
 * */
public class KMP {
	
	public static List<Integer> locatePatternInText (String pattern, String text){
		List<Integer> result = new ArrayList<Integer>();
		if (pattern==null || text==null || text.length()==0 || pattern.length()>text.length()) 
			return result; 
		char[] pArray = pattern.toCharArray();
		char[] tArray = text.toCharArray();
 
		int[] lps = getLPS(pattern);
		int i=0, j = 0; //index for text and pattern
		while (i < text.length()){
			if (pArray[j] == tArray[i]){
				j++;
				i++;
			}
 
			if (j == pattern.length()){
				result.add(i-j);
				// Skip lps[j-1] characters, they will match anyway..
				// match the (lps[j-1]+1)th element, which is pArray[lps[j-1]]
				j = lps[j-1]; 
			}
 
			// mismatch after j matches => p[0...j-1] 
			else if (i < text.length() && pArray[j] != tArray[i])
			{
				// same as above
				if (j != 0)
					j = lps[j-1];
				else
					i = i+1;
			}
		}
		return result;
	}
 
	//lps[i] = the longest proper prefix of pArray[0..i], which is also a suffix of pArray[0..i]. 
	//lps[i] is for (i+1) elements
	private static int[] getLPS(String pattern){
		int[] lps = new int[pattern.length()];
 
		char[] pArray = pattern.toCharArray();
		lps[0] = 0; //lps[0] is always 0
		int i = 1; //current index: start from the second char
		int len = 0; //the length of the previous longest prefix suffix lps[i-1] (in this case lps[0]);
 
 
		while (i<pattern.length()){
			/*
			 * When we are ready to check i, we have the fact that:
			 *     The previous index (i-1) has a lps with length len, which means
			 *     pArray[0..len-1] == pArray[(i-len)...i-1]
			 * Thus, to get lps for i, we only need to match 
			 * 	   the current char: pArray[i] v.s. the (len+1)th char: pArray[len] 
			 */
			if (pArray[i] == pArray[len]){
				/*
				 * If pArray[i] == pArray[len], and based on the fact we have above: 
				 *    pArray[0..len-1] == pArray[(i-len)...i-1])
				 * Then we know that pArray[0..len] == pArray[(i-len)...i], thus we could 
				 *    increase len by 1, set lps[i] and go to the next char
				 */
				len++;
				lps[i] = len;
				i++;
			}
			else{
				if (len != 0) {
					/* MOST CRITICAL
					 * If pArray[i] != pArray[len], and lps[i-1]!=0, 
					 * we need to squeeze the original longest prefix pre0 and profix pro0 for i-1 so as to find a new longest valid pair of pre-profix to fit pArray[i] in 
					 * As pre0 and pre1 has length len, by looking at lps[len-1], we could know the longest prefix pre1 for pre0 & the longest profix pro1 for pro0
					 * Thus we update len = lps[len-1] and rematch pArray[i] with pArray[len], until len==0
					 *    i=7, len=3, we have
					 *      pre0        pro0
					 *   {a  a  a} c {a  a  a} a 
					 *    but pArray[i=>7] != pArray[len=>3]
					 *    so set len=lps[len-1=>2]=2
					 *    pre1           pro1
					 *   {a  a} a  c  a {a  a} a 
					 *    pArray[i=>7] == pArray[len=>2]
					 */
					len = lps[len-1];
 
				}
				else {
					/*
					 * if the previous char has no lps, we cannot backtrack
					 * thus set lps[i] to be 0 and go to the next char
					 */
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	
 
	public static void main(String[] args){
		System.out.print(locatePatternInText("ababc","ababcababc"));
	}

}
