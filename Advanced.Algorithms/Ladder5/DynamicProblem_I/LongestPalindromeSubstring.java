package Ladder5.DynamicProblem_I;
/**
 * 200. Longest Palindromic Substring 
 
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
public class LongestPalindromeSubstring {
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

//Juizhang Solution
//public class Solution {
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0) {
//            return "";
//        }
//        
//        int length = s.length();    
//        int max = 0;
//        String result = "";
//        for(int i = 1; i <= 2 * length - 1; i++){
//            int count = 1;
//            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
//                count++;
//            }
//            count--; // there will be one extra count for the outbound #
//            if(count > max) {
//                result = s.substring((i - count) / 2, (i + count) / 2);
//                max = count;
//            }
//        }
//        
//        return result;
//    }
//    
//    private char get(String s, int i) {
//        if(i % 2 == 0)
//            return '#';
//        else 
//            return s.charAt(i / 2);
//    }
//}
