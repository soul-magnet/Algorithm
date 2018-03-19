package main.java.ladders.CombinationBasedDFS;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 425. Letter Combinations of a Phone Number - Medium - Required

Given a digit string excluded 01, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Cellphone

 Notice
Although the above answer is in lexicographical order, your answer could be in any order you want.

Example
Given "23"

Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

Tags: String Backtracking Recursion Facebook Uber

 * */
public class LetterCombinationsOfAPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result =  new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return result;
        }

        HashMap<Character, char[]> hm = new HashMap<>();
        hm.put('0', new char[] {});
        hm.put('1', new char[] {});
        hm.put('2', new char[] { 'a', 'b', 'c' });
        hm.put('3', new char[] { 'd', 'e', 'f' });
        hm.put('4', new char[] { 'g', 'h', 'i' });
        hm.put('5', new char[] { 'j', 'k', 'l' });
        hm.put('6', new char[] { 'm', 'n', 'o' });
        hm.put('7', new char[] { 'p', 'q', 'r', 's' });
        hm.put('8', new char[] { 't', 'u', 'v'});
        hm.put('9', new char[] { 'w', 'x', 'y', 'z' });

        StringBuilder sb = new StringBuilder();
        helper(hm, digits, sb, result, 0);

        return result;

    }

    private void helper(HashMap<Character, char[]> hm, String digits, StringBuilder sb, ArrayList<String> result, int index) {
        if(sb.length()==digits.length()){
            result.add(new String(sb.toString()) );
            return;
        }
        for (char c: hm.get(digits.charAt(index)) ){
            sb.append(c);
            helper(hm,digits,sb,result,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
