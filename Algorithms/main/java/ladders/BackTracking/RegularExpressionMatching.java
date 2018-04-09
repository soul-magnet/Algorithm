package main.java.ladders.BackTracking;
/**
 * 
 * 154. Regular Expression Matching - Hard
 
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(string s, string p)
 
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

Make sure we totally understand the question.
"." is easy, just representing a single char.
"X*" represent 0 or more x, e.g.,"". "X", "XXX", "XXXXX"...

Tags: String Backtracking Dynamic Programming Facebook Google

Related Problems 
Hard Wildcard Matching 26 %
*/

public class RegularExpressionMatching {
	//Version 1 - Recursive Backtracking
	
	/*Analysis: Check if the first path is match or not. If yes, check the rest of the regular expression.
	 * 1 - Reduction:
	 * 	1.1 - If next chat is not "*", we just compare this current char,
	 *        and reduce the both length of s and p by 1.
	 *  1.2 - If next chat is "*":
	 *        1.2.1 - If the current char is the same, reduce s by 1 and check again. Until the current char is different  - Not Accurate! 
	 *                Consider" "aaa" and "a*a." So every time before we reduce p by 1, we have to check if they match.
	 *                This check must be placed before we reduce p by 1, since we could have the case:s=abc p=.*abc
	 *        1.2.2 - If the current char is different, reduce p by 2.
	 * 2 - Base Case: As reduction reduces the length by  or 2 every time. we need to consider finally when length == 0 or length == 1.
	 * 	2.1 - If p.length() == 0, check s.length() is also 0.
	 * 	2.2 - If p.length()== 1, check if s.length() is also 1 and the char match or not. 
	 * 3 - A detail: s.substring(l), could return null if l is the length of the s.
	 * 4 - A detail: always check s.length
	 * 
	 * */
	
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
	public boolean isMyMatch(String s, String p){
		if(p.length() == 0 || p == null) return s.length() == 0;
		
		//if(p.length() == 1) return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		
		// x* matches empty string or at least one character: x* -> xx*
        // *s is to ensure s is non-empty
		if(p.charAt(1) != '*'){
			 //(isMatch(s, p.substr(2)) || !s.empty() && (s[0] == p[0] || '.' == p[0]) && isMatch(s.substr(1), p));
			return (isMyMatch(s, p.substring(2)) || 
					(s.length() != 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
					isMyMatch(s.substring(1), p));
			
		} else {
			//!s.empty() && (s[0] == p[0] || '.' == p[0]) && isMatch(s.substr(1), p.substr(1));
			return (s.length() != 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMyMatch(s.substring(1), p.substring(1));
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean isMatch1(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        
        if (p.length() == 1) return s.length() == 1  && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        
        // Now, we make sure that p has at least 2 chars.
        if (p.charAt(1) != '*'){
            if (s.length() == 0) return false;
            else return  (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && 
            		isMatch1(s.substring(1), p.substring(1));
        } else { // p.charAt(1) == '*''
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            	// this has to be before s= s.substring(1), to deal with the case: s=abc  p = .*abc
                if (isMatch1(s,p.substring(2))) return true;  
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	//Version 2: DP 
	public boolean isMatch2(String s, String p) {
		return dp(0, s, 0, p);
	}
	
	private boolean dp(int i, String  s, int j, String p) {
		int pn = p.length(), sn = s.length();
		if( j == pn) return i == sn;
		if(p.charAt(j + 1) == '*') {
			if(dp(i, s, j+2, p)) return true;
			while(i < sn && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) if(dp(++i, s, j+2, p)) return true;
		}else if(i<sn && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && dp(i+1, s, j+1, p)) return true;
		
		return false; 
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isMatch(String s, String p) {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // special case
        if (p.length() == 1) {

            // if the length of s is 0, return false
            if (s.length() < 1) {
                return false;
            }

            //if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 1: when the second char of p is not '*'
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            //isMatch("aab", "c*a*b") return true
            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
