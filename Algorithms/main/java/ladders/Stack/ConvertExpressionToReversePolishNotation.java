package main.java.ladders.Stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 370. Convert Expression to Reverse Polish Notation  - Hard - Optional

Given an expression string array, return the Reverse Polish notation of this expression. (remove the parentheses)

Example
For the expression [3 - 4 + 5] (which denote by ["3", "-", "4", "+", "5"]), 
return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"])

Tags:Stack LintCode Copyright

Related Problems 
Medium Evaluate Reverse Polish Notation 26 %
Hard Convert Expression to Polish Notation 26 %
Hard Expression Evaluation 23 %
 * */
public class ConvertExpressionToReversePolishNotation {
	/**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> res =new ArrayList<>();
        Stack<String> operator= new Stack<>();
        for(String crt: expression){
            if(isOperator(crt)){
                while(!operator.isEmpty()&&isOperator(operator.peek())){
                    String op = operator.peek();
                    if(opPrecedence(crt)<=opPrecedence(op) ){
                        res.add(operator.pop());
                    } else{
                        break;
                    }
                }
                operator.push(crt);
            }else if(crt.equals("(")){
                operator.push(crt);
            }else if(crt.equals(")")){
                while(!operator.isEmpty()&&!operator.peek().equals("(")){
                    res.add(operator.pop());
                }
                operator.pop();//"("
            }else{
                //all digit
                res.add(crt);
            }
        }
        while (!operator.isEmpty()){
            res.add(operator.pop());
        }
        return  res;
    }

    private int opPrecedence(String crt) {
        switch (crt){
            case "+": return 1;
            case "-": return 1;
            case "/": return 2;
            case "*": return 2;
            case "^": return 3;
            default: return 5;
        }
    }

    private boolean isOperator(String crt) {
        if("+-*/^".contains(crt)){
            return true;
        }
        return false;
    }
}

//Juizhang Solution
class TreeNode {
    public int val;
	public String s;
	public TreeNode left, right;

	public TreeNode(int val, String ss) {
		this.val = val;
		this.s = ss;
		this.left = this.right = null;
	}

}


class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */

    int get(String a, Integer base) {
		if (a.equals("+") || a.equals("-"))
			return 1 + base;
		if (a.equals("*") || a.equals("/"))
			return 2 + base;

		return Integer.MAX_VALUE;
	}

	void dfs(TreeNode root, ArrayList<String> as) {
		if(root==null)
			return;
		if (root.left != null)
			dfs(root.left, as);
		
		if (root.right != null)
			dfs(root.right, as);
		as.add(root.s);
	}

	public ArrayList<String> convertToRPN(String[] expression) {
		// write your code here
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		int val = 0;
		Integer base = 0;
		for (int i = 0; i <= expression.length; i++) {
			if(i != expression.length)
			{
				
				if (expression[i].equals("(")) {
					base += 10;
					continue;
				}
				if (expression[i].equals(")")) {
					base -= 10;
					continue;
				}
				val = get(expression[i], base);

			}
			TreeNode right = i == expression.length ? new TreeNode(
					Integer.MIN_VALUE, "") : new TreeNode(val,
					expression[i]);
			while (!stack.isEmpty()) {
				if (right.val <= stack.peek().val) {
					TreeNode nodeNow = stack.pop();

					if (stack.isEmpty()) {
						right.left = nodeNow;

					} else {
						TreeNode left = stack.peek();
						if (left.val < right.val) {
							right.left = nodeNow;
						} else {
							left.right = nodeNow;
						}
					}
				} else {
					break;
				}
			}
			stack.push(right);
		}

		ArrayList<String> reversepolish = new ArrayList<String>();
		dfs(stack.peek().left, reversepolish);
		
		
		return reversepolish;
	}

}
