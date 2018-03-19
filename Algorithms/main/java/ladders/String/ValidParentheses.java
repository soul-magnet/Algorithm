package main.java.ladders.String;

import java.util.Scanner;
import java.util.Stack;
/**
 * 423. Valid Parentheses - Easy

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Tags: Stack Uber Google

Related Problems 
Medium Generate Parentheses 37 %
 * */
public class ValidParentheses {
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if ("({[".contains(String.valueOf(c))) {
				stack.push(c);
			} 

			if ((!stack.isEmpty()) && is_valid(stack.peek(), c)) {
				stack.pop();

			}
			if (stack.isEmpty() && ")}]".contains(String.valueOf(c))) {
				//System.out.println( "false");
				return false;

			}
		}
		
		System.out.println( "asdf");
		return stack.isEmpty();
		}

		public static boolean is_valid(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
		|| (c1 == '[' && c2 == ']');
		}
		/**
		* @param args
		*/
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println( isValid( s));
		}

}
