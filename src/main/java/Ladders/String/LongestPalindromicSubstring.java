package String;
/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * Example: Given the string = "abcdzdcab", return "cdzdc".
 * Challenge: O(n2) time is acceptable. Can you do it in O(n) time.
 * 
 * Analysis: Reverse S and become S'. Find the longest common substring
 * between S and S', which must also be the longest palindromic substring.
 * 
 * S = "caba" S' = "abac" --> the longest common substring between S and S'
 * is "aba" But! it is not working in all examples. To rectify this, each time
 * we find a longest common substring candidate, we check if the substring's 
 * indices  are the same as the reversed substring's original indices. 
 * If it is, then we attempt to update the longest palindrome found so far; 
 * if not we skip this and find the next candidate. This gives us O(n^2), and 
 * DP solution which uses O(n^2)space  could be improved ti=o use O(N) space.
 * 
 *  Brute Froce Solution:O(n^3)
 *  The obvious brute force solution is to pick all possible starting and ending 
 *  positions for a substring, and verify if it is a palindrome. 
 *  There are total of C(N,2) suvh substring(excluding the trivial solution
 *  where a character itself is a palindrome)
 *  Since verifying each substring takes O(n) time
 *  
 * Dynamic Programming Solution, O(n^2) time and O(n^2) space
 * Define table[i, j] <-- true iff the substring Si .. Sj is a palindrome, other wise false
 * Therefore initial state:
 * table[i][i] = true;
 * table[i][i+1] = (s[i] == s[i+1]);
 * 
 * State Change:
 * if (s[i] == s[j], table[i][j] = table[i+1][j-1])
 * 
 * */
public class LongestPalindromicSubstring {
	/**
     * @param s input string
     * @return the longest palindromic substring
     */
	
	/*
	 * Naively, we can examine every substring and check if it is palindromic.
	 * The complexity is O(n^3). And it return Time Limit Exceeded!
	 * This approach is just start, we need to better algorithm
	 * */ 
    public String longestPalindrome(String s) {
        int maxPalindLen = 0;
        String longestPalindrome = null;
        int len = s.length();
        
        // check all possible sub Strings
        for (int i = 0; i < len; i++){
        	for (int j = i+1; j< len; j++){
        		int range = j - i;
        		String current = s.substring(i, j + 1);
        		if (isPalindrome(current)){
        			if (range > maxPalindLen){
        				longestPalindrome = current;
        				maxPalindLen = range;
        			}
        		}
        	}
        }
        return longestPalindrome;
    }
    
    public static boolean isPalindrome(String s){
    	for (int i = 0; i < s.length()-1; i++){
    		if (s.charAt(i) != s.charAt(s.length() - 1 -i)){
    			return false;
    		}
    	}
    	return true;
    }
    
    // jiuzhang solution 
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }
        
        return result;
    }
    
    private char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i / 2);
    }
    
    
    
    /* DP Approach: Let s be the input string, i and j are two indices of the string. 
     * Define a 2-dimension array "table" and let table[i][j] denote whether 
     * a substring from i to j is palindrome.
     * Start condition:
     * table[i][i] == 1;
     * table[i][i+1] == 1  => s.charAt(i) == s.charAt(i+1) 
     * Changing condition:
     * table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)=> table[i][j] == 1
     * Time O(n^2) Space O(n^2)
     */
    
    
}
