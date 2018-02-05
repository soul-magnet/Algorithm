package Ladder5.DynamicProblem_I;
/**
 * 200. Longest Palindromic Substring - Medium - Required
 
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Example
Given the string = "abcdzdcab", return "cdzdc".

Challenge 
O(n2) time is acceptable. Can you do it in O(n) time.

Tags: String
Related Problems 
Hard Palindrome Pairs 24 %
Easy Valid Palindrome 24 %
Medium Longest Palindromic Substring 28 %
Medium Palindrome Partitioning II 23 %
 * */
public class LongestPalindromicSubstring {
	
	/**
     * @param s input string
     * @return the longest palindromic substring
     */
        public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return "";
        }//#a# 2*s.length()+1-1
        int max=0;String res ="";
        for(int i=1; i< 2*s.length(); i++){
            int ct =1;
            while(i-ct>=0&&i+ct<=2*s.length()&&get(i-ct, s)==get(i+ct,s)){
                ct++;
            }
            ct--;//a#a#c
            if(max<ct){
                res = s.substring((i-ct)/2,(i+ct)/2); max = ct;
            }
        }
        return res;
    }

    private char get(int i, String s) {
        if(i%2==0){return '#';
        }else{return s.charAt(i/2);
        }
    }

}
