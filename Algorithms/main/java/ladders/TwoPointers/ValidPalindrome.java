package main.java.ladders.TwoPointers;

import java.util.Stack;

/**
 * 415. Valid Palindrome - Easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Notice
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Challenge 
O(n) time without extra memory.

Tags: Two Pointers String Zenefits Facebook Uber

Related Problems 
Easy Valid Palindrome II 34 %
Easy Palindromic Ranges 25 %
Medium Sum of first K even-length Palindrome numbers 42 %
Easy Palindrome Number 36 %
Easy Longest Palindrome 27 %
Medium Palindrome Linked List 29 %
Medium Longest Palindromic Substring 29 %
 * */
public class ValidPalindrome {
	/**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        int l=0, r=s.length()-1;
        Stack<Character> st = new Stack<>();
        while(l<=r){
            while(l<s.length()&&!(Character.isAlphabetic(s.charAt(l))||Character.isDigit(s.charAt(l)))){
                l++;
            }
            while(l<s.length()&&!(Character.isAlphabetic(s.charAt(r))||Character.isDigit(s.charAt(r)))){
                r--;
            }
            //if char is symbol, continues
            if(l>r){
                return true;
            }
            else if (Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))){
               
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }

}
