package main.java.ladders.Stack;

import java.util.Stack;

/**
 * 424. Evaluate Reverse Polish Notation - Medium

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Example
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

Tags: Stack LinkedIn

Related Problems 
Hard Convert Expression to Reverse Polish Notation 27 %
 * */
public class EvaluateReversePolishNotation {
	/**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        if(tokens.length==0||tokens==null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens){
            if(!"/*-+".contains(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                switch (token){
                    case "+": stack.push(a+b);
                        break;
                    case "-": stack.push(a-b);
                        break;
                    case "*": stack.push(a*b);
                        break;
                    case "/": stack.push(a/b);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
