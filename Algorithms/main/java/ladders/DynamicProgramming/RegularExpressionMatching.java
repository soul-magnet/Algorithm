package main.java.ladders.DynamicProgramming;
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
isMatch("aa", "a") → true 
isMatch("aa", ".") → true 
isMatch("ab", ".") → true 
isMatch("aab", "ca*b") → true

Make sure we totally understand the question.
“.” is easy, just representing a single char.
“x*” represent 0 or more x, e.g., “”,”x”,”xx”,”xxx”,”xxxxxx”…

Tags: String Backtracking Dynamic Programming Facebook Google

Related Problems 
Hard Wildcard Matching 26 %
*/

public class RegularExpressionMatching {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
	
	//Version 1: Recursive - backtracking
	//Reduction: 
	//1. If next char is not "*", we jsut compare this current char, and reduce both the length of s and p by 1.
	//2. If next char is "*":
	//	2.1 If the current char is the same, reduces s by 1 and check again.Until the current char is different -Not Accurate
	//      Consider the case "aaa" and "a*a." So every time before we reduce p by 1, we have to check if they match.
	//		This check must to be placed before we reduce p by 1, since we could have the case: s=abc p=.*abc
	//	2.2 If the current char is different reduce p by 2.
	//3. Base Case: As reduction reduces the length by 1 or 2 every time, we need to consider finally when length == 0 or length == 1
	//	3.1 if p.length() == 0, check if s.length() is also 0.
	//	3.2 If p.length() == 1, check if s.length() is also 1 and the match or not
	//4. A detail; s.subString(l), could return null if the l is the length of the s.
	//5. A detail: always check s.length
	public boolean isMatch1(String s, String p) {
        if (p.length() == 0){
            return s.length() == 0;
        }
        if (p.length() == 1){
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
         
        // Now, we make sure that p has at least 2 chars.
        if (p.charAt(1) != '*'){
            if (s.length() == 0) return false;
            else return  (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')&& isMatch(s.substring(1), p.substring(1));
 
        }else{ // p.charAt(1) == '*''
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
                if (isMatch(s,p.substring(2))) return true;  // this has to be before s= s.substring(1), to deal with the case: s=abc  p = .*abc
                 
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
         
    }
	
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
