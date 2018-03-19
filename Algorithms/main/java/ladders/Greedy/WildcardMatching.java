package main.java.ladders.Greedy;
/**
 * 192. Wildcard Matching - Hard

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
 
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
Tags 
String Backtracking Greedy Dynamic Programming Google
Related Problems 
Hard Regular Expression Matching 23 %
 * */
public class WildcardMatching {
	/**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            //1to1 char match
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            }
            //* case: store * index starIndex, store crt iIndex,
            // Match mathch starIndex+1 with crt i to the end of i
            //until next *, any mismatch will to back to mathch starIndex+1 with previous iIdex.
            //if mismatch *+1, then p index go back to starindex+1
            else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            }
            //until next *, any mismatch will to back to mathch starIndex+1 with previous iIdex.
            else if (starIndex != -1) {
                j = starIndex + 1;
                iIndex++;
                i = iIndex;

            } else {
                return false;
            }
        }

        while (j < p.length() ) {
            if(p.charAt(j) != '*'){
                return false;
            }
            j++;
        }

        return true;
    }
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch1(String s, String p) {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // special case
        if (p.length() == 1) {


            if(p.charAt(0)=='*'){
                return true;
            }
            // if the length of s is 0, return false
            else if (s.length() < 1) {
                return false;
            }
            //if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '?')) {
                return false;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        //case len >= 2
        // case 1: when the second char of p is not '*'
        if (p.charAt(0) != '*') {
            if (s.length() < 1) {
                return false;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '?')) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            //isMatch("aab", "c*a*b") return true
            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i<s.length() ){
                if (isMatch(s.substring(i), p.substring(1))) {
                    return true;
                }
                i++;
            }
            return false;
        }
     }

}
