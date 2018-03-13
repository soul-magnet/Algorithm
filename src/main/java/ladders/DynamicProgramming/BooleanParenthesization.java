package main.java.ladders.DynamicProgramming;
/**
 * 725. Boolean Parenthesization - Hard

Given a boolean expression with following symbols.

Symbols
    'T' ---> true 
    'F' ---> false 
And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}

Have you met this question in a real interview? 
Example
Given symbol = ['T', 'F', 'T'], operator = ['^', '&']
return 2
The given expression is "T ^ F & T", it evaluates true, in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

given symbol = ['T', 'F', 'F'], operator = ['^', '|']
return 2
The given expression is "T ^ F | F", it evaluates true, in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".

Tags: Dynamic Programming Google
 * */
public class BooleanParenthesization {
	/**
     * @param symb: the array of symbols
     * @param oper: the array of operators
     * @return: the number of ways
     */
    public int countParenth(char[] symb, char[] oper) {
        // write your code here
    }
}
